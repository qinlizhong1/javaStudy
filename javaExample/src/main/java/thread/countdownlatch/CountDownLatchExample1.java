package thread.countdownlatch;

import java.util.Calendar;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class DoHomeworkRunnable implements Runnable{
    CountDownLatch countDownLatch = null;
    private int i;

    public DoHomeworkRunnable(CountDownLatch countDownLatch, int i) {
        this.countDownLatch = countDownLatch;
        this.i = i;
    }

    @Override
    public void run() {
        try {
            Thread.sleep((i+1)*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println((i+1) + "号同学完成了作业");
        countDownLatch.countDown();
    }
}

//一个线程等待其他多个线程都执行完毕，再继续自己的工作
public class CountDownLatchExample1 {
    public static void main(String[] args) throws InterruptedException {
        long startTime = Calendar.getInstance().getTimeInMillis();
        CountDownLatch countDownLatch = new CountDownLatch(3);
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (int i=0; i<3; i++){
            executorService.submit(new DoHomeworkRunnable(countDownLatch, i));
        }

        System.out.println("等待所有同学都完成 作业");
        countDownLatch.await();
        System.out.println("所有同学都完成作业，放学");

        long endTime = Calendar.getInstance().getTimeInMillis();
        System.out.println("程序执行了  " + (endTime -  startTime) + " ms");
    }
}
