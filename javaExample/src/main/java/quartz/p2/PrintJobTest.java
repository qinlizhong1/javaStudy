package quartz.p2;

import org.quartz.*;

import org.quartz.impl.StdSchedulerFactory;

public class PrintJobTest {
    public static void main(String[] args) throws SchedulerException {
        //1.获取Scheduler
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

        //2.创建 JobDetail,要做什么
        JobDetail jobDetail = JobBuilder.newJob(PrintJob.class)
                .withIdentity("printJobDetail", "qin-jobDetail")
                .withDescription("第一个quartz定时任务jobDetail")
                .usingJobData("jobDetail-k1", "jobDetail-v1")
                .usingJobData("common-k1", "common-v1--jobDetail")
                .build();

        //3.创建 Trigger,什么时候做
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("printTrigger", "qin-trigger")
                .withDescription("第一个quartz定时任务trigger")
                .usingJobData("trigger-k1", "trigger-v1")
                .usingJobData("common-k1", "common-v1--trigger")
                .startNow()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(3).repeatForever())
                .build();

        //4、关联 job和 trigger
        scheduler.scheduleJob(jobDetail, trigger);

        //5、启动，否则定时任务不会执行
        scheduler.start();;
    }
}
