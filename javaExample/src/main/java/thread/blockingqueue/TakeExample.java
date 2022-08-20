package thread.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

//take示例
public class TakeExample {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> blockingQueue =
                new ArrayBlockingQueue<String>(1);

        blockingQueue.take();
        System.out.println("测试能否执行到这一句");
    }
}
