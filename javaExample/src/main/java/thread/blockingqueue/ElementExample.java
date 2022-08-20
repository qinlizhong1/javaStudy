package thread.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

//element示例
public class ElementExample {
    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue =
                new ArrayBlockingQueue<String>(1);
        blockingQueue.element();
    }
}
