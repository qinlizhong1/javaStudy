package redis.cache;

class CacheTest{
    public void getUserInfo(String id){
        String name = RedisUtil.getUserFromRedis(id);
        if (name != null){
            System.out.println("【redis】：" + "{" + id + " ," + name + "}");
        }else{
            name = DbUtil.getUserFromDb(id);
            if (name != null){
                System.out.println("【db】：" + "{" + id + " ," + name + "}");
                RedisUtil.setUserToRedis(id, name);
            }else {
                System.out.println("该用户不存在");
            }
        }
    }
}

public class CacheExample {
    public static void main(String[] args) {
        CacheTest cacheTest = new CacheTest();
        System.out.println("【查询601用户信息】--------->");
        cacheTest.getUserInfo("601");

        System.out.println("\n【查询604用户信息】--------->");
        cacheTest.getUserInfo("604");

        System.out.println("\n【再次查询604用户信息】--------->");
        cacheTest.getUserInfo("604");

        System.out.println("\n【查询555用户信息】--------->");
        cacheTest.getUserInfo("555");

        System.out.println("\n【再次查询555用户信息】--------->");
        cacheTest.getUserInfo("555");
    }
}
