package thread.completionservice;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

@Data
@AllArgsConstructor
class NanHangCallable implements Callable<Double>{
    private String companyName;

    @Override
    public Double call() throws Exception {
        //模拟查询花费了4s
        Thread.sleep(3000);
        return 1000.0;
    }
}

@Data
@AllArgsConstructor
class DongFangCallable implements Callable<Double>{
    private String companyName;

    @Override
    public Double call() throws Exception {
        //模拟查询花费了2s
        Thread.sleep(2000);
        return 1200.0;
    }
}

@Data
@AllArgsConstructor
class XiamenCallable implements Callable<Double>{
    private String companyName;

    @Override
    public Double call() throws Exception {
        //模拟查询花费了1s
        Thread.sleep(1000);
        return 800.0;
    }
}


public class CompletionServiceExample1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        NanHangCallable nanHang = new NanHangCallable("南航");
        DongFangCallable dongFang = new DongFangCallable("东方航空");
        XiamenCallable xiaMen = new XiamenCallable("厦门航空");

        Future<Double> future1 = executorService.submit(nanHang);
        Future<Double> future2 = executorService.submit(dongFang);
        Future<Double> future3 = executorService.submit(xiaMen);

        Double price1 = future1.get();
        System.out.println("花费的时间:" + (System.currentTimeMillis() - start));
        System.out.println(nanHang.getCompanyName() + "票价:" + future1.get());

        Double price2 = future2.get();
        System.out.println(dongFang.getCompanyName() + "票价:" + future2.get());

        Double price3 = future3.get();
        System.out.println(xiaMen.getCompanyName() + "票价:" + future3.get());
    }
}
