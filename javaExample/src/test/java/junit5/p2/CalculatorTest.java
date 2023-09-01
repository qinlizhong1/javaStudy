package junit5.p2;

import org.junit.jupiter.api.*;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

//Juint5 常用断言，断言很多，只举其中1，2个案例
public class CalculatorTest {
    private static Calculator calculator = null;
    @BeforeAll
    public static void init() {
        System.out.println("BeforeAll--->初始化数据");
        calculator = new Calculator();
    }

    @Test
    public void testAdd() {
        System.out.println("testAdd 方法开始测试");
        Assertions.assertEquals(3, calculator.add(1, 2));
    }

    @Test
    public void testDiv() {
        System.out.println("testDiv 方法开始测试");

    }

    //我们期望测试用例在一秒钟之内成功。但是执行的代码休眠两秒钟，
    @Test
    @DisplayName("超时方法测试")
    void testTimeOut() {
        System.out.println("testTimeOut 方法开始测试");
        Assertions.assertTimeoutPreemptively(Duration.of(1, ChronoUnit.SECONDS), () -> Thread.sleep(2000));
    }


    //assertThrows第一个参数为异常类型，第二个为函数式接口参数，跟 Runnable 接口相似，不需要参数，也没有返回，
    //当Lambda表达式中代码出现的异常会跟首个参数的异常类型进行比较，如果不属于同一类异常，
    @Test
    @DisplayName("测试捕获的异常")
    void testAssertThrowsException() {
        System.out.println("testAssertThrowsException 方法开始测试");
        String str = null;
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Integer.valueOf(str);
        });
    }

    @Test
    public void testString() {
        System.out.println("testString 方法开始测试");

        String s1 = null;
        Assertions.assertNull(s1, "s1 is null");
        System.out.println("11111111111111");
        Assertions.assertNotNull(s1, "s1 is null");

        //前面断言失败，后面不会执行
        System.out.println("22222222222222");
    }
}
