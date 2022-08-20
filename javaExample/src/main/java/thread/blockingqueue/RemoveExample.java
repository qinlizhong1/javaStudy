package thread.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

//remove方法示例
public class RemoveExample {
    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue =
                new ArrayBlockingQueue<String>(1);
        blockingQueue.add("1");
        System.out.println("remove element:" + blockingQueue.remove());

        blockingQueue.remove();
    }
}
