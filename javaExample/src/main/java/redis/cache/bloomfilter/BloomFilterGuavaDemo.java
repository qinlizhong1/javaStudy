package redis.cache.bloomfilter;

import com.google.common.base.Charsets;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

public class BloomFilterGuavaDemo {
    //布隆过滤器里预计要插入多少数据
    public static final int SIZE = 1000000;
    //误判率,它越小误判的个数也就越少
    public static double FBP = 0.03;

    public static void main(String[] args) {
        BloomFilter<CharSequence> bf =
                BloomFilter.create(Funnels.stringFunnel(Charsets.UTF_8), SIZE, FBP);
        // 初始化 1000000 条数据到过滤器中
        for (int i = 0; i < SIZE; i++) {
            bf.put("" + i);
        }
        // 判断值是否存在过滤器中
        int count = 0;
        for (int i = 0; i < SIZE + 10000; i++) {
            if (bf.mightContain("" + i)) {
                count++;
            }
        }
        System.out.println("已匹配数量 " + count);
    }
}

