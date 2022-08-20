package thread.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

//put示例
public class PutExample {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> blockingQueue =
                new ArrayBlockingQueue<String>(2);

        blockingQueue.put("1");
        blockingQueue.put("2");
        System.out.println("【0】blockingQueue  size:" + blockingQueue.size());
        blockingQueue.put("3");

        System.out.println("【1】blockingQueue  size:" + blockingQueue.size());
    }
}
