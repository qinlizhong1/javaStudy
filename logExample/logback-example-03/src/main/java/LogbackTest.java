import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class LogbackExample{

    public void test1(){
        System.out.println("----------------------   test1 --------------------");
        Logger logger = LoggerFactory.getLogger(LogbackExample.class);
        for (int i = 0; i < 100; i++) {
            logger.trace("trace级别信息");
            logger.debug("debug级别信息");
            logger.info("info级别信息");
            logger.warn("warn级别信息");
            logger.error("error级别信息");
        }
        for (int i = 0; i < 600; i++) {
            System.out.println("——————————————");
        }
    }

}

public class LogbackTest {
    public static void main(String[] args) {
        LogbackExample logbackExample = new LogbackExample();
        logbackExample.test1();
    }
}
