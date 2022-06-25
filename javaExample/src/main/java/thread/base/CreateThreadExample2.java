package thread.base;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

//实现Callable接口并指定返回值
class MyCallable implements Callable<String> {
    //实现Callable接口中的call()方法。
    @Override
    public String call()throws Exception{
        System.out.println("I am thread:" + Thread.currentThread().getName());
        return "子线程的返回值";
    }
}



public class CreateThreadExample2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //创建Callable实现类的实例
        Callable callable = new MyCallable();
        //使用FutureTask包装类来包装Callable对象
        FutureTask<String> futureTask = new FutureTask<>(callable);
        //使用FutureTask对象作为Thread对象的target创建并启动新线程
        Thread thread = new Thread(futureTask);
        thread.start();
        System.out.println("主线程获取到:" + futureTask.get());
        System.out.println("I am thread:" + Thread.currentThread().getName());
    }
}
