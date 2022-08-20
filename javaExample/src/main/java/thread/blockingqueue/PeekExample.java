package thread.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class PeekExample {
    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue =
                new ArrayBlockingQueue<String>(1);

        System.out.println(blockingQueue.peek());
    }
}


