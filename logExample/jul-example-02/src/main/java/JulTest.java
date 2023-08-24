import java.io.IOException;
import java.util.logging.*;

class JulExample{
    //Logger 可以添加多个处理器 Handler，这里即输出到文件，又输出到控制台
    public void test1() throws IOException {
        System.out.println("----------------------   test1 --------------------");

        Logger logger = Logger.getLogger("JulExample");
        logger.setUseParentHandlers(false);
        FileHandler fileHandler = new FileHandler("/Users/qin/logs/logExample/jul-02/jul_02.log");

        SimpleFormatter simpleFormatter = new SimpleFormatter();
        fileHandler.setFormatter(simpleFormatter);
        fileHandler.setLevel(Level.CONFIG);

        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.INFO);

        logger.setLevel(Level.ALL);
        logger.addHandler(fileHandler);
        logger.addHandler(consoleHandler);

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
