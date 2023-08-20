package quartz.p3;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import quartz.p2.PrintJob;

class PersistJobSample{
    //默认是无状态Job
    public void test1() throws SchedulerException {
        //1.获取Scheduler
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

        //2.创建 JobDetail,要做什么
        JobDetail jobDetail = JobBuilder.newJob(UnPersistJob.class)
                .usingJobData("num", 1)
                .build();

        //3.创建 Trigger,什么时候做
        Trigger trigger = TriggerBuilder.newTrigger()
                .startNow()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2).repeatForever())
                .build();

        //4、关联 job和 trigger
        scheduler.scheduleJob(jobDetail, trigger);

        //5、启动，否则定时任务不会执行
        scheduler.start();;
    }

    public void test2() throws SchedulerException {
        //1.获取Scheduler
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

        //2.创建 JobDetail,要做什么
        JobDetail jobDetail = JobBuilder.newJob(PersistJob.class)
                .usingJobData("num", 1)
                .build();

        //3.创建 Trigger,什么时候做
        Trigger trigger = TriggerBuilder.newTrigger()
                .startNow()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2).repeatForever())
                .build();

        //4、关联 job和 trigger
        scheduler.scheduleJob(jobDetail, trigger);

        //5、启动，否则定时任务不会执行
        scheduler.start();;
    }
}


public class PersistJobTest {
    public static void main(String[] args) throws SchedulerException {
        PersistJobSample persistJobSample = new PersistJobSample();
        persistJobSample.test2();


    }
}
