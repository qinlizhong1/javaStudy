package log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogbackExample {
    private static Logger logger= LoggerFactory.getLogger(LogbackExample.class);
    public static void main(String[] args) {
        logger.debug("debug 信息");
        logger.info("info 信息");
        logger.warn("warn 信息");
        logger.error("error 信息");
    }
}
