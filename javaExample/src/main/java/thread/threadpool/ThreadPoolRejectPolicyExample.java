package thread.threadpool;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class MyRunnabless implements Runnable{
    private int i;
    MyRunnabless(int i){
        this.i = i;
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

class ThreadPoolRejectPolicyTest{
    //AbortPolicy策略
    public void testAbortPolicy(){
        ExecutorService executorService = new ThreadPoolExecutor(2, 4, 2, TimeUnit.SECONDS, new ArrayBlockingQueue<>(2));
        for (int i=0; i<10; i++){
            executorService.submit(new MyRunnabless(i));
        }
    }
    //DiscardPolicy策略
    public void testDiscardPolicy(){
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 4, 2, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(2));
        threadPoolExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardPolicy());
        for (int i=0; i<10; i++){
            threadPoolExecutor.submit(new MyRunnabless(i));
        }
    }

    //DiscardOldestPolicy策略
    public void testDiscardOldestPolicy(){
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 4, 2, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(2));
        threadPoolExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardOldestPolicy());
        for (int i=0; i<10; i++){
            threadPoolExecutor.submit(new MyRunnabless(i));
        }
    }

    //CallerRunsPolicy策略
    public void testCallerRunsPolicy(){
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 4, 2, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(2));
        threadPoolExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        for (int i=0; i<10; i++){
            threadPoolExecutor.submit(new MyRunnabless(i));
        }
    }
}

//线程池拒绝策略测试
public class ThreadPoolRejectPolicyExample {
    public static void main(String[] args) {
        ThreadPoolRejectPolicyTest threadPoolRejectPolicyTest = new ThreadPoolRejectPolicyTest();
        //threadPoolRejectPolicyTest.testAbortPolicy();
        //threadPoolRejectPolicyTest.testDiscardPolicy();
        //threadPoolRejectPolicyTest.testDiscardOldestPolicy();
        threadPoolRejectPolicyTest.testCallerRunsPolicy();
    }
}
