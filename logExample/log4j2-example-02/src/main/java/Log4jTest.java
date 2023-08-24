import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import java.nio.file.attribute.BasicFileAttributes;

class Log4jExample{
    //
    public void test1(){
        System.out.println("----------------------   test1 --------------------");
        Logger logger = Logger.getLogger(Log4jExample.class);

        logger.trace("trace信息");
        logger.debug("debug信息");
        logger.info("info信息");
        logger.warn("warn信息");
        logger.error("error信息");
        logger.fatal("fatal信息");

        BasicConfigurator.configure();
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

public class Log4jTest {
    public static void main(String[] args) {
        Log4jExample log4jExample = new Log4jExample();
        log4jExample.test1();
    }
}
