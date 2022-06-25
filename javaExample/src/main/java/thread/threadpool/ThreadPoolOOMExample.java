package thread.threadpool;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class MyRunnables implements Runnable{
    private long[] arr = new long[10000];
    @Override
    public void run() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy/MM/dd-HH:mm:ss");
        String time = simpleDateFormat.format(new Date());
        System.out.println(time + " 线程"  + Thread.currentThread().getName() + " 执行任务");
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ThreadPoolOOMtest{
    public void testNewFixedThreadPoolOOM(){
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i=0; i<6000000; i++){
            executorService.submit(new MyRunnables());
        }
    }
}

public class ThreadPoolOOMExample {
    public static void main(String[] args) {
        ThreadPoolOOMtest threadPoolOOMtest = new ThreadPoolOOMtest();
        threadPoolOOMtest.testNewFixedThreadPoolOOM();
    }
}
