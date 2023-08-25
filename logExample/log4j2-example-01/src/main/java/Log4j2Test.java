import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class Log4j2Example{
    //
    public void test1(){
        System.out.println("----------------------   test1 --------------------");
        Logger logger = LoggerFactory.getLogger(Log4j2Example.class);
        logger.trace("trace级别信息");
        logger.debug("debug级别信息");
        logger.info("info级别信息");
        logger.warn("warn级别信息");
        logger.error("error级别信息"); // 默认级别

    }

    public void test2(){
        System.out.println("----------------------   test1 --------------------");
    }

    public void test3(){
        System.out.println("----------------------   test1 --------------------");
    }

    public void test4(){
        System.out.println("----------------------   test1 --------------------");
    }
}

public class Log4j2Test {
    public static void main(String[] args) {
        Log4j2Example log4j2Example = new Log4j2Example();
        log4j2Example.test1();
    }
}
