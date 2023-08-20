package log.debugpackage;

import org.apache.log4j.Logger;

public class DebugLog4jExample {
        private static Logger logger = Logger.getLogger(DebugLog4jExample .class);

        public static void main(String[] args) {
            logger.debug("debug 信息");
            logger.info("info 信息");
            logger.warn("warn 信息");
            logger.error("error 信息");
            logger.fatal("fatal 信息");
        }
}
