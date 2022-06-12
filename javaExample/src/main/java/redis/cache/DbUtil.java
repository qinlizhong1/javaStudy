package redis.cache;

import java.util.HashMap;
import java.util.Map;

//模拟数据库操作
public class DbUtil {
    //模拟数据库中存放的数据
    private static final Map<String, String> dbUserMap;

    static {
        dbUserMap = new HashMap<>();
        dbUserMap.put("601", "zhang");
        dbUserMap.put("602", "li");
        dbUserMap.put("603", "wang");
        dbUserMap.put("604", "张三丰");
    }

    public static String getUserFromDb(String id){
        System.out.println("从数据库查询数据");
        if (dbUserMap.containsKey(id)){
            return dbUserMap.get(id);
        }
        return null;
    }
}
