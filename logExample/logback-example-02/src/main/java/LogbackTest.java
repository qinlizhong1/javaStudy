import dao.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class LogbackExample{

    //对照配置文测试
    public void test1(){
        System.out.println("----------------------   test1 --------------------");
        Logger logger = LoggerFactory.getLogger(LogbackExample.class);
        logger.trace("trace 信息");
        logger.debug("debug 信息"); // 默认级别
        logger.debug("debug 信息 qin"); // 用来测试自定义过滤器
        logger.info("info 信息");
        logger.warn("warn 信息");
        logger.error("error 信息 qin");
    }

}

public class LogbackTest {
    public static void main(String[] args) {
        LogbackExample logbackExample = new LogbackExample();
        logbackExample.test1();

        UserDao userDao = new UserDao();
        userDao.userDaoFun();
    }
}
