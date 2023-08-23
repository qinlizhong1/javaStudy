import java.io.IOException;
import java.util.logging.*;

/*
SEVERE (highest value)
WARNING
INFO
CONFIG
FINE
FINER
FINEST  (lowest value)
*/

//建议每个测试方法单独测试
class JulExample{

    //方式一： 调用log函数，函数中传递level参数来定义日志的级别
    public void test1(){
        System.out.println("----------------------   test1 --------------------");
        //getLogger参是当前类的全限定名
        Logger logger = Logger.getLogger("JulExample");

        logger.log(Level.SEVERE, "server 级别信息");
        logger.log(Level.WARNING, "warning 级别信息");
        logger.log(Level.INFO, "info 级别信息");
        logger.log(Level.CONFIG, "config 级别信息");
        logger.log(Level.FINE, "fine 级别信息");
        logger.log(Level.FINER, "finer  级别信息");
        logger.log(Level.FINEST, "finest  级别信息");
    }

    //方式二： 调用对应的级别函数，每个级别对应一个函数，这样在函数中就不需要传递level参数了
    public void test2() {
        System.out.println("\n----------------------   test2 --------------------");

        //getLogger参是当前类的全限定名
        Logger logger = Logger.getLogger("JulExample");

        logger.severe  ("server 级别信息");
        logger.warning(" warning 级别信息");
        logger.info("info 级别信息");
        logger.config("config 级别信息");
        logger.fine("fine 级别信息");
        logger.finer("finer  级别信息");
        logger.finest("finest  级别信息");
    }


    //自定义日志级别：只需打印warning及以上级别日志
    public void test3() {
        Logger logger = Logger.getLogger("JulExample");

        // 参数设置为 false，打印日志的方式就不会按照父 logger 默认的方式去进行操作
        logger.setUseParentHandlers(false);
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.WARNING);
        logger.setLevel(Level.WARNING);

        logger.addHandler(consoleHandler);

        logger.severe  ("server 级别信息");
        logger.warning(" warning 级别信息");
        logger.info("info 级别信息");
        logger.config("config 级别信息");
        logger.fine("fine 级别信息");
        logger.finer("finer  级别信息");
        logger.finest("finest  级别信息");

    }

    //打印的消息需要进行字符串拼接
    public void test4() {
        Logger logger = Logger.getLogger("JulExample");
        String name = "郭靖";
        Integer age = 28;

        //这种方式：效率低，可读性低
        logger.log(Level.WARNING, "姓名:" + name + "   年龄:" + age);

        //第二种方式：动态拼接, 参数的传递只能通过Object数组进行传递
        logger.log(Level.WARNING, "姓名:{0} 年龄:{1}", new Object[]{name, age});

    }

    //日志打印到文件
    public void test5() throws IOException {
        Logger logger = Logger.getLogger("JulExample");

        // 参数设置为 false，打印日志的方式就不会按照父 logger 默认的方式去进行操作
        logger.setUseParentHandlers(false);
        FileHandler fileHandler = new FileHandler("/Users/qin/logs/logExample/jul-01/jul_01.log");

        //设置日志格式为简单格式
        SimpleFormatter simpleFormatter = new SimpleFormatter();
        fileHandler.setFormatter(simpleFormatter);
        //fileHandler.s

        //两个级别取级别高的打印，下面的设置只会打印WARNING级别日志
        logger.setLevel(Level.CONFIG);
        fileHandler.setLevel(Level.WARNING);

        logger.addHandler(fileHandler);

        logger.severe  ("server 级别信息");
        logger.warning(" warning 级别信息");
        logger.info("info 级别信息");
        logger.config("config 级别信息");
        logger.fine("fine 级别信息");
        logger.finer("finer  级别信息");
        logger.finest("finest  级别信息");

    }
}


public class JulTest {
    public static void main(String[] args) throws IOException {
        JulExample julExample = new JulExample();
        //julExample.test1();
        //julExample.test2();
        //julExample.test3();
        //julExample.test4();
        julExample.test5();
    }
}
