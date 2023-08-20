package guava.p1;

import com.google.common.cache.*;

import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CallableExample {
    // 模拟DB
    private static final HashMap<Integer, String> map = new HashMap<>();

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Cache<Integer, String> cache = CacheBuilder.newBuilder()
                //设置缓存初始容量为8
                .initialCapacity(6)
                //设置缓存最大容量为8，超过8之后就会按照LRU最近虽少使用算法来移除缓存项
                .maximumSize(8)
                //设置并发级别为3，并发级别是指可以同时写缓存的线程数
                .concurrencyLevel(3)
                //缓存项在3秒钟内没有更新就会被回收,需要注意的是：guava 不会⾃动清除清除数据，只有在访问时候再去判断 expire。
                .expireAfterWrite(3, TimeUnit.SECONDS)
                //设置统计缓存的各种统计信息（生产坏境关闭）
                .recordStats()
                //设置缓存的移除通知
                .removalListener(new RemovalListener<Object, Object>() {
                    @Override
                    public void onRemoval(RemovalNotification<Object, Object> removalNotification) {
                        System.out.println(removalNotification.getKey() + " has remove, cause is " + removalNotification.getCause());
                    }
                })
                .build();

        map.put(1,"张三");
        map.put(2,"李四");
        map.put(3,"王五");


        //返回缓存中的值，如果缓存中没有，则通过Callable进行加载并返回，该操作是原子
        // 第一次缓存中没有数据，所以会往DB中查询数据加载到缓存并返回
        System.out.println(cache.get(2, new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("---call中加载数据至缓存--");
                return map.get(2);
            }
        }));
        // 第二次缓存中有数据，不会被加载
        System.out.println(cache.get(2, new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("---call中加载数据至缓---");
                return map.get(2);
            }
        }));

        //缓存容量
        System.out.println("\n缓存容量: " + cache.size());


        //缓存统计：缓存构建时CacheBuilder.recordStats()用来开启 Guava Cache 的统计功能，
        // 统计打开后，Cache.stats()方法会返回CacheStats对象提供缓存命中等统计信息

        System.out.println("缓存命中次数: " + cache.stats().hitCount());
        System.out.println("缓存miss次数: " + cache.stats().missCount());

        System.out.println("缓存命中率: " + cache.stats().hitRate());
        System.out.println("缓存miss率: " + cache.stats().missRate());

        System.out.println("缓存加载次数: " + cache.stats().loadCount());
    }
}
