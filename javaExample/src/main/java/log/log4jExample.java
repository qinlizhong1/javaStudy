package log;


import org.apache.log4j.Logger;

public class log4jExample {
    private static  Logger logger = Logger.getLogger(log4jExample.class);

    public static void main(String[] args) {
        logger.debug("debug 信息");
        logger.info("info 信息");
        logger.warn("warn 信息");
        logger.error("error 信息");
        logger.fatal("fatal 信息");
    }
}
