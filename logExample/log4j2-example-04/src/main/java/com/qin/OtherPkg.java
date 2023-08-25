package com.qin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OtherPkg {

    public void test1(){
        System.out.println("----------------------   test1 --------------------");
        Logger logger = LoggerFactory.getLogger(OtherPkg.class);

        for (int i = 0; i < 100; i++) {
            logger.trace("【OtherPkg】trace级别信息");
            logger.debug("【OtherPkg】debug级别信息");
            logger.info("【OtherPkg】info级别信息");
            logger.warn("【OtherPkg】warn级别信息");
            logger.error("【OtherPkg】error级别信息"); // 默认级别
        }

        for (int i = 0; i < 100; i++) {
            System.out.println("【OtherPkg】——————————————");
        }
    }
}
