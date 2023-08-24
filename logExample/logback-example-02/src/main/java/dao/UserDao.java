package dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserDao {
    public void userDaoFun(){
        System.out.println("----------------------   test1 --------------------");
        Logger logger = LoggerFactory.getLogger(UserDao .class);
        logger.trace("【UserDao】trace 信息");
        logger.debug("【UserDao】debug 信息"); // 默认级别
        logger.debug("【UserDao】debug 信息 qin"); // 用来测试自定义过滤器
        logger.info("【UserDao】info 信息");
        logger.warn("【UserDao】warn 信息");
        logger.error("【UserDao】error 信息 qin");
    }
}
