package thread.threadpool;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class MyRunnablesss implements Runnable{
    private int i;
    MyRunnablesss(int i){
        this.i = i;
    }

    @Override
    public void run() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy/MM/dd-HH:mm:ss");
        String time = simpleDateFormat.format(new Date());

        System.out.println(time + " 线程"  + Thread.currentThread().getName() + " 开始执行任务" + i);
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }

        String endTime = simpleDateFormat.format(new Date());
        System.out.println(endTime + " 线程"  + Thread.currentThread().getName() + " 正常执行完毕任务" + i);
    }
}

class ThreadPoolShutTest{
    //不手动关闭线程池，然后强制stop程序
    public void testNoShut(){
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 2, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(2));
        threadPoolExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());

        for (int i=0; i<6; i++){
            threadPoolExecutor.submit(new MyRunnablesss(i));
        }
    }

    //Shutdown关闭线程池
    public void testShutdown(){
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 2, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(2));
        threadPoolExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());

        for (int i=0; i<5; i++){
            threadPoolExecutor.submit(new MyRunnablesss(i));
        }

        threadPoolExecutor.shutdown();
    }

    //ShutdownNow关闭线程池
    public void testShutdowNow(){
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 2, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(2));
        threadPoolExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());

        for (int i=0; i<5; i++){
            threadPoolExecutor.submit(new MyRunnablesss(i));
        }

        threadPoolExecutor.shutdownNow();
    }
}

//线程池关闭测试
public class ThreadPoolShutExample {
    public static void main(String[] args) {
        ThreadPoolShutTest threadPoolShutTest = new ThreadPoolShutTest();
        //threadPoolShutTest.testNoShut();
        //threadPoolShutTest.testShutdown();
        threadPoolShutTest.testShutdowNow();
    }
}
