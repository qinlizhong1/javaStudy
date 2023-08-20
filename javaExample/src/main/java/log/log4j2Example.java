package log;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class log4j2Example {
    private static Logger logger = LogManager.getLogger("myLogger");

    public static void main(String[] args) {
        logger.debug("debug 信息");
        logger.info("info 信息");
        logger.warn("warn 信息");
        logger.error("error 信息");
        logger.fatal("fatal 信息");
    }
}
