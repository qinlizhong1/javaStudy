package thread.future;

//购买钢笔任务
class BuyPenRunnable implements Runnable{
    private String pen;

    @Override
    public void run() {
        System.out.println("【购买钢笔】：下单，等待送货上门");

        //模拟送货时间
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("【购买钢笔】：快递送到");
        pen = "神笔";
    }

    public String getPen() {
        return pen;
    }
}

public class CommomThreadExample {
    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();

        BuyPenRunnable buyPenRunnable = new BuyPenRunnable();
        Thread buyPenThread = new Thread(buyPenRunnable);
        buyPenThread.start();

        //保证笔送到
        buyPenThread.join();

        //模拟整理书桌耗时3000ms
        System.out.println("【整理书桌】：开始整理");
        Thread.sleep(3000);
        System.out.println("【整理书桌】：整理完了");

        //所有准备好，开始练字
        write(buyPenRunnable.getPen());

        long endTime = System.currentTimeMillis();
        System.out.println("总共用时 " + (endTime - startTime) + " ms");

    }

    private static void write(String pen){
        System.out.println("【开始写字】：" + pen);
    }
}
