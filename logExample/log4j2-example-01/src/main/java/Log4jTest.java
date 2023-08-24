import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

class Log4jExample{
    //不提供配置文件，默认级别为debug
    public void test1(){
        System.out.println("----------------------   test1 --------------------");
        //如果没有提供log4j配置文件，要使用 BasicConfigurator.configure() 加载初始化配置
        BasicConfigurator.configure();
        //参数为所在
        Logger logger = Logger.getLogger(Log4jExample.class);

        logger.trace("trace信息");
        logger.debug("debug信息"); //默认级别
        logger.info("info信息");
        logger.warn("warn信息");
        logger.error("error信息");
        logger.fatal("fatal信息");
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
