package quartz.p2;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.text.SimpleDateFormat;
import java.util.Date;

//实现Job接口，重写execute方法，该方法是我们需要执行的任务
public class PrintJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String now=simpleDateFormat.format(new Date());
        System.out.println(" 【PrintJob】: " + now + " : " + Thread.currentThread().getName() + "------>执行定时任务~~" );
        System.out.println("jobDetail组：" + jobExecutionContext.getJobDetail().getKey().getGroup());
        System.out.println("jobDetail名称：" + jobExecutionContext.getJobDetail().getKey().getName());
        System.out.println("trigger组：" + jobExecutionContext.getTrigger().getKey().getGroup());
        System.out.println("trigger名称：" + jobExecutionContext.getTrigger().getKey().getName());

        System.out.println("\n--->jobDetail设置的参数");
        JobDataMap jobDataMap = jobExecutionContext.getJobDetail().getJobDataMap();
        String[] jobDetailDataMapKeys = jobDataMap.getKeys();
        for (String key :  jobDetailDataMapKeys){
            System.out.println(key + ":" + jobDataMap.get(key));
        }

        System.out.println("\n--->trigger设置的参数");
        JobDataMap jobDataMapTrigger = jobExecutionContext.getTrigger().getJobDataMap();
        String[] triggerDataMapKeys = jobDataMapTrigger.getKeys();
        for (String key :  triggerDataMapKeys){
            System.out.println(key + ":" + jobDataMapTrigger.get(key));
        }

        System.out.println("\n");
    }
}
