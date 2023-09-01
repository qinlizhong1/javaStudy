package utils;

import redis.clients.jedis.Jedis;

public class JedisSetUtils {
    private static Jedis jedis = null;
    static {
        jedis = new Jedis("localhost", 6381, 100, 100);
    }

    private JedisSetUtils(){

    }

    //关闭连接
    public static void closeCommand(){
        jedis.close();
    }
}
