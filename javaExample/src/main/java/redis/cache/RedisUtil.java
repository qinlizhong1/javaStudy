package redis.cache;

import java.util.HashMap;
import java.util.Map;

//模拟redis缓存操作
public class RedisUtil {
    //模拟redis中存放的数据
    private static final Map<String, String> redisUserMap;

    static {
        redisUserMap = new HashMap<>();
        redisUserMap.put("601", "zhang");
        redisUserMap.put("602", "li");
        redisUserMap.put("603", "wang");
    }

    //模拟往redis中获取缓存数据
    public static String getUserFromRedis(String id){
        System.out.println("从redis查询数据");
        if (redisUserMap.containsKey(id)){
            return redisUserMap.get(id);
        }
        return null;
    }

    //模拟往redis中存放缓存数据
    public static void setUserToRedis(String id, String name){
        System.out.println("设置数据到redis");
        redisUserMap.put(id, name);
    }
}
