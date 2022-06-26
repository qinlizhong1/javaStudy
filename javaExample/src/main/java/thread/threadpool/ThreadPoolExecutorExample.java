package thread.threadpool;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.*;

class MyRunnable implements Runnable{
    private int i;
    MyRunnable(int i){
        this.i = i;
    }

    MyRunnable(){
        this.i = 8;
    }

    @Override
    public void run() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy/MM/dd-HH:mm:ss");
        String time = simpleDateFormat.format(new Date());
        System.out.println(time + " 线程"  + Thread.currentThread().getName() + " 执行任务" + i);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ThreadPoolExecutorTest{
    public void testThreadPoolExecutor(){
        ExecutorService executorService = new ThreadPoolExecutor(2, 4, 2, TimeUnit.SECONDS, new ArrayBlockingQueue<>(2));
        for (int i=0; i<10; i++){
            executorService.submit(new MyRunnable(i));
        }
    }

    public void testNewFixedThreadPool(){
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i=0; i<6; i++){
            executorService.submit(new MyRunnable(i));
        }
    }

    public void testNewSingleThreadExecutor() throws InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i=0; i<6; i++){
            executorService.submit(new MyRunnable(i));
        }
    }

    public void testCachedThreadPool(){
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i=0; i<6; i++){
            executorService.submit(new MyRunnable(i));
        }
    }

    public void testScheduledThreadPool1(){
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);
        executorService.schedule(new MyRunnable(), 4, TimeUnit.SECONDS);
    }

    public void testScheduledThreadPool2(){
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);
        executorService.scheduleAtFixedRate(new MyRunnable(), 4, 3, TimeUnit.SECONDS);
    }

    public void testScheduledThreadPool3(){
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);
        executorService.scheduleWithFixedDelay(new MyRunnable(), 4, 3, TimeUnit.SECONDS);
    }
}

public class ThreadPoolExecutorExample {
    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutorTest threadPoolExecutorTest = new ThreadPoolExecutorTest();
        threadPoolExecutorTest.testThreadPoolExecutor();
        //threadPoolExecutorTest.testNewFixedThreadPool();
        //threadPoolExecutorTest.testNewSingleThreadExecutor();

        //SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy/MM/dd-HH:mm:ss");
        //String time = simpleDateFormat.format(new Date());
        //System.out.println(time + " main 开始运行");
        //threadPoolExecutorTest.testCachedThreadPool();
        //threadPoolExecutorTest.testScheduledThreadPool1();
        //threadPoolExecutorTest.testScheduledThreadPool2();
        //threadPoolExecutorTest.testScheduledThreadPool3();
    }
}
