package quartz.p3;

import org.quartz.*;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UnPersistJob implements Job {
    private int num;

    public void setNum(int num) {
        this.num = num;
    }


    public UnPersistJob(){
        System.out.println("UnPersistJob无参构造函数");
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String now=simpleDateFormat.format(new Date());
        System.out.println(" 【PrintJob】: " + now + " : " + Thread.currentThread().getName() + "------>执行定时任务~~" );

        System.out.println("\n--->jobDetail设置的参数");


        System.out.println("num:" + num + "\n");

        num++;
        jobExecutionContext.getJobDetail().getJobDataMap().put("num", num);

    }
}
