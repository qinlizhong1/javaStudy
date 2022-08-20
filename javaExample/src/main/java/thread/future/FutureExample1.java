package thread.future;

import java.util.Calendar;
import java.util.concurrent.*;

class MyCallable implements Callable<String>{
    @Override
    public String call() throws Exception {
        Thread.sleep(2000);
        return "Hello Future";
    }
}

public class FutureExample1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long startTime = Calendar.getInstance().getTimeInMillis();

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Future<String> future = executorService.submit(new MyCallable());

        System.out.println("子线程返回值:" + future.get());

        long endTime = Calendar.getInstance().getTimeInMillis();
        System.out.println("程序执行了  " + (endTime -  startTime) + " ms");
    }
}
