import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class LogbackExample{

    //不提供日志配置文件
    public void test1(){
        System.out.println("----------------------   test1 --------------------");
        Logger logger = LoggerFactory.getLogger(LogbackExample.class);
        logger.trace("trace 信息");
        logger.debug("debug 信息"); // 默认级别
        logger.info("info 信息");
        logger.warn("warn 信息");
        logger.error("error 信息");
    }

    public void test2(){
        System.out.println("----------------------   test1 --------------------");
    }

    public void test3(){
        System.out.println("----------------------   test1 --------------------");
    }
}

public class LogbackTest {
    public static void main(String[] args) {
        LogbackExample logbackExample = new LogbackExample();
        logbackExample.test1();
    }
}
