package thread.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

//offer示例
public class OfferExample {
    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue =
                new ArrayBlockingQueue<String>(2);

        boolean res1 = blockingQueue.offer("1");
        boolean res2 = blockingQueue.offer("2");
        boolean res3 = blockingQueue.offer("3");

        System.out.println("res1:" + res1);
        System.out.println("res2:" + res2);
        System.out.println("res3:" + res3);
        System.out.println("blockingQueue  size:" + blockingQueue.size());
    }
}
