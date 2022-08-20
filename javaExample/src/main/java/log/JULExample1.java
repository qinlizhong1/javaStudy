package log;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.*;

class JULTest1{
    public void test1(){
        //getLogger函数参数的命名：通常使用当前类的全限定类名(包名+类名)
        Logger logger = Logger.getLogger("log.Test1");
        logger.log(Level.FINEST, "我是 FINEST 级别日志");
        logger.log(Level.FINER, "我是 FINER 级别日志");
        logger.log(Level.FINE, "我是 FINE 级别日志");
        logger.log(Level.CONFIG, "我是 CONFIG 级别日志");
        logger.log(Level.INFO, "我是 INFO 级别日志");
        logger.log(Level.WARNING, "我是 WARNING 级别日志");
        logger.log(Level.SEVERE, "我是 SEVERE 级别日志");
    }

    public void test2(){
        Logger logger = Logger.getLogger("log.Test1");
        logger.finest("我是 FINEST 级别日志");
        logger.finer("我是 FINER 级别日志");
        logger.fine("我是 FINE 级别日志");
        logger.config("我是 CONFIG 级别日志");
        logger.info("我是 INFO 级别日志");
        logger.warning("我是 WARNING 级别日志");
        logger.severe("我是 SEVERE 级别日志");
    }

    public void test3() throws IOException {
        Logger logger = Logger.getLogger("log.Test1");
        //1. 关闭系统默认配置
        logger.setUseParentHandlers(false);
        //2.1 创建ConsoleHandler
        ConsoleHandler consoleHandler = new ConsoleHandler();
        //2.2 创建简单格式转换对象
        SimpleFormatter simpleFormatter = new SimpleFormatter();

        //3.设置日志具体级别
        logger.setLevel(Level.ALL);
        consoleHandler.setLevel(Level.ALL);

        //4. consoleHandler设置转换对象，并将consoleHandler关联到logger
        consoleHandler.setFormatter(simpleFormatter);
        logger.addHandler(consoleHandler);

        //如果想将CONFIG级别的日志还输出到指定文件中，可以添加一个FileHandler对象
        FileHandler fileHandler = new FileHandler("/Users/qin/Desktop/develop/javaStudy/javaExample/src/main/java/log/jul.log");
        fileHandler.setFormatter(simpleFormatter);
        fileHandler.setLevel(Level.CONFIG);
        logger.addHandler(fileHandler);

        logger.finest("我是 FINEST 级别日志");
        logger.finer("我是 FINER 级别日志");
        logger.fine("我是 FINE 级别日志");
        logger.config("我是 CONFIG 级别日志");
        logger.info("我是 INFO 级别日志");
        logger.warning("我是 WARNING 级别日志");
        logger.severe("我是 SEVERE 级别日志");
    }

    public void test4() throws IOException {
        //1.通过类加载器 读取配置文件
        InputStream inputStream = JULTest1.class.getClassLoader().getResourceAsStream("mylogging.properties");
        //2.创建LogManager
        LogManager logManager = LogManager.getLogManager();
        //3.通过LogManger加载配置文件
        logManager.readConfiguration(inputStream);

        Logger logger = Logger.getLogger("log.Test1");
        logger.finest("我是 FINEST 级别日志");
        logger.finer("我是 FINER 级别日志");
        logger.fine("我是 FINE 级别日志");
        logger.config("我是 CONFIG 级别日志");
        logger.info("我是 INFO 级别日志");
        logger.warning("我是 WARNING 级别日志");
        logger.severe("我是 SEVERE 级别日志");
    }

}

public class JULExample1 {
    public static void main(String[] args) throws IOException {

        JULTest1 julTest1 = new JULTest1();
        //julTest1.test1();
        //julTest1.test2();
        //julTest1.test3();
        julTest1.test4();
    }
}
