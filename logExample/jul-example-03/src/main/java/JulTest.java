import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.LogManager;
import java.util.logging.Logger;

class JulExample{
    //
    public void test1() throws IOException {
        System.out.println("----------------------   test1 --------------------");

        // 读取自定义日志配置文件
        InputStream input = new FileInputStream("/Users/qin/Desktop/develop/javaStudy/logExample/jul-example-03/src/main/resources/myLogging.properties");
        // 获取日志管理器
        LogManager logManager = LogManager.getLogManager();
        // 日志管理器读取自定义配置文件
        logManager.readConfiguration(input);
        // 日志记录器
        Logger logger = Logger.getLogger("com.jul.JulTest");


        logger.severe  ("server 级别信息");
        logger.warning(" warning 级别信息");
        logger.info("info 级别信息");
        logger.config("config 级别信息");
        logger.fine("fine 级别信息");
        logger.finer("finer  级别信息");
        logger.finest("finest  级别信息");
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

public class JulTest {
    public static void main(String[] args) throws IOException {
        JulExample julExample = new JulExample();
        julExample.test1();
    }
}
