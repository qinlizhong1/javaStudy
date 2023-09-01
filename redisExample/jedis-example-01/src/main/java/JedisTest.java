import redis.clients.jedis.Jedis;
import utils.JedisCommonUtils;
import utils.JedisPoolUtils;
import utils.JedisStringUtils;

class JedisExample{

    //通用命令测试
    public void testConmmon(){
        System.out.println("------------------  testConmon  ------------------");
        System.out.println("keys--->" + JedisCommonUtils.keysCommand());
        System.out.println("type--->" + JedisCommonUtils.typeCommand());
        System.out.println("objectencoding--->" + JedisCommonUtils.objectCommand());
        System.out.println("exists--->" + JedisCommonUtils.existsCommand());
        System.out.println("dbsize--->" + JedisCommonUtils.dbSizeCommand());
        System.out.println("expire--->" + JedisCommonUtils.expireCommand());
        System.out.println("ttl--->" + JedisCommonUtils.ttlCommand());
        System.out.println("flshdb--->" + JedisCommonUtils.flshdbCommand());
    }

    //String类型命令测试
    public void testString(){
        System.out.println("\n------------------  testString  ------------------");
        System.out.println("set--->" + JedisStringUtils.setCommand());
        System.out.println("setnx--->" + JedisStringUtils.setnxCommand());
        System.out.println("setex--->" + JedisStringUtils.setexCommand());
    }

    //List类型命令测试
    public void testList(){
        System.out.println("\n------------------  testList  ------------------");
    }

    //Hash类型命令测试
    public void testHash(){
        System.out.println("\n------------------  testHash  ------------------");
    }

    //Set类型命令测试
    public void testSet(){
        System.out.println("\n------------------  testSet  ------------------");
    }

    //Zset类型命令测试
    public void testZset(){
        System.out.println("\n------------------  testZset  ------------------");
    }

    //JedisPool测试
    public void testJedisPool(){
        System.out.println("\n------------------  testJedisPool  ------------------");
        JedisPoolUtils.getJedisPoolConfig();
        Jedis jedis = JedisPoolUtils.getJedisConnection();
        JedisPoolUtils.getJedisConnection();
        System.out.println("11111111111111111");
        JedisPoolUtils.getJedisPoolConfig();
        System.out.println(jedis);
    }

}

public class JedisTest {
    public static void main(String[] args) {
        JedisExample jedisExample = new JedisExample();
        //jedisExample.testConmmon();

        jedisExample.testJedisPool();
    }
}
