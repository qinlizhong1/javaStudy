package thread.future;

import java.util.concurrent.*;

class ExceptionCallable implements Callable<String>{
    @Override
    public String call() throws Exception {
        throw new ArithmeticException();
    }
}

public class FutureExample2 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        Future<String> future = executorService.submit(new ExceptionCallable());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("isDone result:" + future.isDone());

        try {
            future.get();
        }
        catch (InterruptedException e)
        {
            System.out.println("捕获到InterruptedException异常");
            e.printStackTrace();
        } catch (ArithmeticException e) {
            System.out.println("捕获到ArithmeticException异常");
            e.printStackTrace();
        } catch (ExecutionException e) {
            System.out.println("捕获到ExecutionException异常");
            e.printStackTrace();
        }
    }
}
