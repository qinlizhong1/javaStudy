package thread.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

//poll示例
public class PollExample {
    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue =
                new ArrayBlockingQueue<String>(1);
        blockingQueue.offer("1");

        //不允许放入null，否则会抛出NullPointerException异常
        //blockingQueue.offer(null);
        System.out.println("poll element:" + blockingQueue.poll());
        System.out.println("poll element:" + blockingQueue.poll());
    }
}
