package redis.cache.bloomfilter;

import org.redisson.Redisson;
import org.redisson.api.RBloomFilter;
import org.redisson.api.RedissonClient;
import org.redisson.client.codec.StringCodec;
import org.redisson.config.Config;

public class BloomFilterRedisDemo {
    //布隆过滤器里预计要插入多少数据
    public static final int SIZE = 1000000;
    //误判率,它越小误判的个数也就越少
    public static double FBP = 0.01;

    static RedissonClient redissonclient = null;
    static RBloomFilter rBLoomFilter = null;

    static {
        Config config = new Config();
        //构造redisson
        config.useSingleServer().setAddress("redis://127.0.0.1:6379").setDatabase(0);
        redissonclient = Redisson.create(config);

        //通过redisson构造rBLoomFilter
        rBLoomFilter = redissonclient.getBloomFilter("testBloomFilter", new StringCodec());
        rBLoomFilter.tryInit(SIZE, FBP);
    }


    public static void main(String[] args) {
        for (int i = 0; i < SIZE; i++) {
            rBLoomFilter.add("" + i);
        }
        // 判断值是否存在过滤器中
        int count = 0;
        for (int i = 0; i < SIZE + 10000; i++) {
            if (rBLoomFilter.contains("" + i)) {
                count++;
            }
        }
        System.out.println("已匹配数量 " + count);

    }
}
