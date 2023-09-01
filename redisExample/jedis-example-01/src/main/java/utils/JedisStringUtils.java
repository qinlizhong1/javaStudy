package utils;

import redis.clients.jedis.Jedis;

import java.util.Set;

public class JedisStringUtils {
    private static Jedis jedis = null;
    static {
        jedis = new Jedis("localhost", 6381, 100, 100);
    }

    private JedisStringUtils(){

    }

    //set k1 v1 nx
    public static String setCommand(){

        return jedis.set("k1", "v1");
    }

    //set k1 v1 nx
    public static Long setnxCommand(){

        return jedis.setnx("k2", "v2");
    }

    //setex k1   30 v1
    public static String setexCommand(){

        return jedis.setex("k3", 30, "v1");
    }

    //清除数据，让下个测试时环境更干净
    public static void flshdbCommand(){
        jedis.flushDB();
    }

    //关闭连接
    public static void closeCommand(){
        jedis.close();
    }
}
