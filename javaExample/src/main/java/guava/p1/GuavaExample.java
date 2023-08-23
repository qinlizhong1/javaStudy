package guava.p1;

import com.google.common.cache.*;

import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

class GuavaTest{
    // 模拟DB
    private HashMap<Integer, String> map = new HashMap<>();

    public LoadingCache<Integer, String> createGuavaCache(){
        return CacheBuilder.newBuilder()
                //设置缓存初始容量为8
                .initialCapacity(3)
                //设置缓存最大容量为8，超过8之后就会按照LRU最近虽少使用算法来移除缓存项
                .maximumSize(4)
                //设置并发级别为3，并发级别是指可以同时写缓存的线程数
                .concurrencyLevel(3)
                //缓存项在3秒钟内没有更新就会被回收,需要注意的是：guava 不会⾃动清除清除数据，只有在访问时候再去判断 expire。
                //.expireAfterWrite(3, TimeUnit.SECONDS)
                .expireAfterAccess(3, TimeUnit.SECONDS)
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
    }

    //CacheLoader和Callable同时存在，则走Callable的call方法加载缓存
    public void test1() throws ExecutionException {
        System.out.println("---------------------- test1 -----------------------");
        map.put(1,"张一");
        map.put(2,"李二");
        map.put(3,"王三");
        map.put(4,"曾四");
        map.put(5,"彭五");
        map.put(6,"马六");

        LoadingCache<Integer, String> cache = createGuavaCache();
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
    }

    //maximumSize(4)：当缓存容量超过4，再放入数据到缓存，会使用LRU算法清除缓存
    public void test2(){
        System.out.println("\n---------------------- test2 -----------------------");

        LoadingCache<Integer, String> cache = createGuavaCache();
        cache.put(1,"张一");
        cache.put(2,"李二");
        cache.put(3,"王三");
        cache.put(4,"曾四");
        cache.put(5,"彭五");
        cache.put(6,"马六");


    }

    //缓存项在3秒钟内没有更新就会被回收,需要注意的是：guava 不会⾃动清除清除数据，只有在访问时候再去判断 expire。
    // expireAfterWrite(3, TimeUnit.SECONDS)
    public void test3() throws InterruptedException, ExecutionException {
        map.put(1,"张一");
        map.put(2,"李二");
        map.put(3,"王三");

        System.out.println("\n---------------------- test3 -----------------------");

        LoadingCache<Integer, String> cache = createGuavaCache();
        cache.put(1,"张一");
        Thread.sleep(2000);

        System.out.println(cache.get(1));

        //此时已经经过了4s，超过设置的3s（expireAfterWrite(3, TimeUnit.SECONDS)），该缓存项再被访问会先删除
        Thread.sleep(2000);
        System.out.println(cache.get(1));
    }

    //expireAfterAccess(3, TimeUnit.SECONDS)  注意和test3区别
    public void test4() throws InterruptedException, ExecutionException {
        System.out.println("\n---------------------- test4 -----------------------");

        map.put(1,"张一");
        map.put(2,"李二");
        map.put(3,"王三");

        System.out.println("\n---------------------- test3 -----------------------");

        LoadingCache<Integer, String> cache = createGuavaCache();
        cache.put(1,"张一");
        Thread.sleep(2000);

        System.out.println(cache.get(1));

        //此时已经经过了4s，超过设置的3s（expireAfterWrite(3, TimeUnit.SECONDS)），该缓存项再被访问会先删除
        Thread.sleep(2000);
        System.out.println(cache.get(1));
    }

    //
    public void test5(){
        System.out.println("\n---------------------- test5 -----------------------");
    }

    public void test6(){
        System.out.println("\n---------------------- test6 -----------------------");
    }
}

public class GuavaExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        GuavaTest guavaTest = new GuavaTest();
        //guavaTest.test1();
        //guavaTest.test2();
        //guavaTest.test3();
        guavaTest.test4();
    }
}
