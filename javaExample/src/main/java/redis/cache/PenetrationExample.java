package redis.cache;


//校验参数方式防止缓存穿透
class CheckParamTest{
    public Boolean isValidId(String id){
        if (id.startsWith("6")){
            return true;
        }

        return false;
    }

    public void testCheckParam(String id){
        if (isValidId(id)){
            String name = RedisUtil.getUserFromRedis(id);
            if (name != null){
                System.out.println("【redis】：" + "{" + id + "," + name + "}");
            }else{
                name = DbUtil.getUserFromDb(id);
                if (name != null){
                    System.out.println("【db】：" + "{" + id + "," + name + "}");
                    RedisUtil.setUserToRedis(id, name);
                }
            }
        }else{
            System.out.println("非法id");
        }
    }
}

//缓存空对象防止缓存穿透
class NullObjCache{
    public void getUser(String id){
        String name = RedisUtil.getUserFromRedis(id);
        if (name != null){
            System.out.println("【redis】：" + "{" + id + "," + name + "}");
        }else{
            name = DbUtil.getUserFromDb(id);
            if (name != null){
                System.out.println("【db】：" + "{" + id + "," + name + "}");
                RedisUtil.setUserToRedis(id, name);
            }else {
                //对于不存在的对象缓存为""
                RedisUtil.setUserToRedis(id, "");
                System.out.println("该用户不存在");
            }
        }
    }
}


//缓存穿透
public class PenetrationExample {
    public static void main(String[] args) {
        /*
        CheckParamTest checkParamTest = new CheckParamTest();

        System.out.println("\n【查询555用户信息】--------->");
        checkParamTest.testCheckParam("555");

        System.out.println("\n【再次查询555用户信息】--------->");
        checkParamTest.testCheckParam("555");
        */

        NullObjCache nullObjCache = new NullObjCache();
        System.out.println("\n【查询555用户信息】--------->");
        nullObjCache.getUser("555");

        System.out.println("\n【第二次查询555用户信息】--------->");
        nullObjCache.getUser("555");

        System.out.println("\n【第三次查询555用户信息】--------->");
        nullObjCache.getUser("555");
    }
}
