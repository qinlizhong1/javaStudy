package thread.future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

//购买钢笔任务
class BuyPenCallable implements Callable {

    @Override
    public String call() {
        System.out.println("【购买钢笔】：下单，等待送货上门");

        //模拟送货时间
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("【购买钢笔】：快递送到");
        return "神笔";
    }
}

public class FutureTaskExample2 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        long startTime = System.currentTimeMillis();

        Callable<String> callable = new BuyPenCallable();
        FutureTask<String> futureTask = new FutureTask<>(callable);
        Thread buyPenThread = new Thread(futureTask);
        buyPenThread.start();

        //模拟整理书桌耗时3000ms
        System.out.println("【整理书桌】：开始整理");
        Thread.sleep(3000);
        System.out.println("【整理书桌】：整理完了");

        //所有准备好，开始练字
        write(futureTask.get());

        long endTime = System.currentTimeMillis();
        System.out.println("总共用时 " + (endTime - startTime) + " ms");

    }

    private static void write(String pen){
        System.out.println("【开始写字】：" + pen);
    }
}
