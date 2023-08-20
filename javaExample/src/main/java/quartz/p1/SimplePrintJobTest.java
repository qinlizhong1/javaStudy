package quartz.p1;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class SimplePrintJobTest {
    public static void main(String[] args) throws SchedulerException {
        //1.获取Scheduler
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

        //2.创建 JobDetail,要做什么
        JobDetail jobDetail = JobBuilder.newJob(SimplePrintJob.class)
                .build();

        //3.创建 Trigger,什么时候做
        Trigger trigger = TriggerBuilder.newTrigger()
                .startNow()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(3).repeatForever())
                .build();

        //4、关联 job和 trigger
        scheduler.scheduleJob(jobDetail, trigger);

        //5、启动，否则定时任务不会执行
        scheduler.start();;
    }
}
