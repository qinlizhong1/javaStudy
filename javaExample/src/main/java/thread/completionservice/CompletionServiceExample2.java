package thread.completionservice;


import java.util.concurrent.*;

public class CompletionServiceExample2 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        long start = System.currentTimeMillis();
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        CompletionService<Double> completionService = new ExecutorCompletionService<>(executorService);

        completionService.submit(new NanHangCallable("南航"));
        completionService.submit(new DongFangCallable("东方航空"));
        completionService.submit(new XiamenCallable("厦门航空"));

        for (int i=0; i<3; i++){
            Double price = completionService.take().get();
            //System.out.println(nanHang.getCompanyName() + "票价:" + future1.get());

            System.out.println("花费了 " + (System.currentTimeMillis() - start)
                    + " ms获取到价格为:"+ price);
        }

    }
}
