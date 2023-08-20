package guava.p1;


import com.google.common.cache.*;

import java.util.HashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;


/*
guava⽬前有三种刷新本地缓存的机制：
expireAfterAccess：当缓存项在指定的时间段内没有被读或写就会被回收。
expireAfterWrite：当缓存项在指定的时间段内没有更新就会被回收。-- 常用
refreshAfterWrite：当缓存项上一次更新操作之后的多久会被刷新。 -- 常用


*/
public class CacheBuilderExample {
    // 模拟DB
    private static final HashMap<Integer, String> map = new HashMap<>();

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        LoadingCache<Integer, String> loadingCache = CacheBuilder.newBuilder()
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
                // 指定CacheLoader，在缓存不存在时通过CacheLoader的实现自动加载缓存
                .build(new CacheLoader<Integer, String>() {
                    @Override
                    public String load(Integer key) throws Exception {
                        // 模拟往DB中查询数据
                        System.out.println("查询key:" + key + "的数据");
                        return map.get(key);
                    }
                });

        map.put(1,"张三");
        map.put(2,"李四");
        map.put(3,"王五");


        ////从LoadingCache查询使用get方法。这个方法要么返回已经缓存的值，要么使用CacheLoader向缓存原子地加载新值
        // 第一次缓存中没有数据，所以会往DB中查询数据
        System.out.println(loadingCache.get(2));
        // 第二次缓存中有数据，CacheLoader.load方法不会加载
        System.out.println(loadingCache.get(2));
        System.out.println(loadingCache.get(2));

        Thread.sleep(4000);
        System.out.println(loadingCache.get(2));

        //缓存容量
        System.out.println("\n缓存容量: " + loadingCache.size());


        //缓存统计：缓存构建时CacheBuilder.recordStats()用来开启 Guava Cache 的统计功能，
        // 统计打开后，Cache.stats()方法会返回CacheStats对象提供缓存命中等统计信息

        System.out.println("缓存命中次数: " + loadingCache.stats().hitCount());
        System.out.println("缓存miss次数: " + loadingCache.stats().missCount());

        System.out.println("缓存命中率: " + loadingCache.stats().hitRate());
        System.out.println("缓存miss率: " + loadingCache.stats().missRate());

        System.out.println("缓存加载次数: " + loadingCache.stats().loadCount());
    }
}
