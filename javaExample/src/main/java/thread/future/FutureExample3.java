package thread.future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class CancelCallable implements Callable {
    @Override
    public String call() throws Exception {
        int i = 0;

        while (i == 1) {
            System.out.println("z");
        }
        System.out.println("执行任务");
        return "always run";
    }
}
public class FutureExample3 {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Future<String> future = executorService.submit(new CancelCallable());

        Thread.sleep(1000);
        System.out.println(future.cancel(true) +
                " " + future.isCancelled());
    }
}
