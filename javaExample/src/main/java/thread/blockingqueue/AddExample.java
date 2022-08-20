package thread.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class AddExample {
    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue =
                new ArrayBlockingQueue<String>(2);

        blockingQueue.add("1");
        blockingQueue.add("2");
        System.out.println("blockingQueue  size:" + blockingQueue.size());

        blockingQueue.add("3");
    }
}
