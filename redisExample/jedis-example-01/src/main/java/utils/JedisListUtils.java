package utils;

import redis.clients.jedis.Jedis;

public class JedisListUtils {
    private static Jedis jedis = null;
    static {
        jedis = new Jedis("localhost", 6381, 100, 100);
    }

    private JedisListUtils(){

    }


    //关闭连接
    public static void closeCommand(){
        jedis.close();
    }
}
