package utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class JedisPoolUtils {
    private static JedisPool jedisPool;

    static {

        //读取配置文件
        InputStream is = JedisPoolUtils.class.getClassLoader().getResourceAsStream("jedis.properties");
        //创建Properties对象
        Properties pro = new Properties();
        //关联文件
        try {
            pro.load(is);
        } catch (IOException e) {

            e.printStackTrace();
        }

        //获取数据，设置到JedisPoolConfig中
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(Integer.parseInt(pro.getProperty("maxTotal")));
        config.setMaxIdle(Integer.parseInt(pro.getProperty("maxIdle")));

        //初始化JedisPool
        jedisPool = new JedisPool(config,pro.getProperty("host"),Integer.parseInt(pro.getProperty("port")));
    }

    //获取连接池参数配置
    public static void getJedisPoolConfig(){
        System.out.println("NumActive--->" + jedisPool.getNumActive());
        System.out.println("NumIdle--->" + jedisPool.getNumIdle());
        System.out.println("NumWaiters--->" + jedisPool.getNumWaiters());
        System.out.println("BorrowWaitTimeMillis--->" + jedisPool.getMaxBorrowWaitTimeMillis());
        System.out.println("MeanBorrowWaitTimeMillis--->" + jedisPool.getMeanBorrowWaitTimeMillis());
    }

    //获取连接池中的一个连接
    public static Jedis getJedisConnection(){
        return jedisPool.getResource();
    }


}
