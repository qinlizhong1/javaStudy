package thread.future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class FutureTaskCallable implements Callable{
    @Override
    public String call() throws Exception {
        return "Hello FutureTask";
    }
}

public class FutureTaskExample1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> futureTask =
                new FutureTask<>(new FutureTaskCallable());

        Thread thread = new Thread(futureTask);
        thread.start();

        System.out.println("子线程返回值:" + futureTask.get());
    }
}
