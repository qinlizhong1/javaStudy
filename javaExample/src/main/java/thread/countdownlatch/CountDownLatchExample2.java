package thread.countdownlatch;


import java.util.Calendar;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class ReadyRunnable implements Runnable{
    CountDownLatch countDownLatch = null;
    private int i;

    public ReadyRunnable(CountDownLatch countDownLatch, int i) {
        this.countDownLatch = countDownLatch;
        this.i = i;
    }

    @Override
    public void run() {
        System.out.println((i+1) + "号同学进入教室 ,等待老师喊起立");
        try {
            countDownLatch.await();
            System.out.println((i+1) + "号同学站起");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

//多个线程等待某一个线程的信号，同时开始执行
public class CountDownLatchExample2 {
    public static void main(String[] args) throws InterruptedException {
        long startTime = Calendar.getInstance().getTimeInMillis();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (int i=0; i<3; i++){
            executorService.submit(new ReadyRunnable(countDownLatch, i));
        }

        Thread.sleep(5000);
        countDownLatch.countDown();
        System.out.println("5秒准备时间已过，老师喊起立！");
        long endTime = Calendar.getInstance().getTimeInMillis();
        System.out.println("程序执行了  " + (endTime -  startTime) + " ms");
    }
}
