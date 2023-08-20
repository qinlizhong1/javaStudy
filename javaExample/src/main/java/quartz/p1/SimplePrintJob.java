package quartz.p1;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.text.SimpleDateFormat;
import java.util.Date;

//实现Job接口，重写execute方法，该方法是我们需要执行的任务
public class SimplePrintJob implements Job {
    public SimplePrintJob(){
       System.out.println("SimplePrintJob无参构造函数");

    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String now=simpleDateFormat.format(new Date());

        //打印当前对象信息，验证每次执行任务，Job会重新实例化
        System.out.println(this);
        System.out.println(" 【PrintJob】: " + now + " : " + Thread.currentThread().getName() + "------>执行定时任务~~\n" );
    }
}
