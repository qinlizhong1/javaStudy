package utils;

import redis.clients.jedis.Jedis;

public class JedisZsetUtils {
    private static Jedis jedis = null;
    static {
        jedis = new Jedis("localhost", 6381, 100, 100);
    }

    private JedisZsetUtils(){

    }

    //关闭连接
    public static void closeCommand(){
        jedis.close();
    }
}
