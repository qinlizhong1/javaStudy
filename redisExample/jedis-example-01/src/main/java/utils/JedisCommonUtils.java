package utils;

import redis.clients.jedis.Jedis;

import java.util.HashSet;
import java.util.Set;

public class JedisCommonUtils {
    private static Jedis jedis = null;
    static {
        jedis = new Jedis("localhost", 6381, 100, 100);
    }

    private JedisCommonUtils(){

    }

    //keys *
    public static Set<String> keysCommand(){
        jedis.set("k1", "v1");
        jedis.set("k2", "v2");
        return jedis.keys("*");
    }

    //type key1
    public static String typeCommand(){
        return jedis.type("k1");
    }

    //type key1
    public static String objectCommand(){
        return jedis.objectEncoding("k1");
    }

    //exists k2
    public static Boolean existsCommand(){
        return jedis.exists("k2");
    }

    //dbsize
    public static Long dbSizeCommand(){
        return jedis.dbSize();
    }

    //expire key2 20
    //设置成功，返回值1
    public static Long expireCommand(){
        return jedis.expire("k2", 20);
    }

    //ttl k2
    public static Long ttlCommand(){
        return jedis.ttl("k2");
    }

    //flshdb
    public static String flshdbCommand(){
        return jedis.flushDB();
    }

    //关闭连接
    public static void closeCommand(){
        jedis.close();
    }


}
