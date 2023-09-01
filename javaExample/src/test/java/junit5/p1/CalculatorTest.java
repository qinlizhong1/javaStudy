package junit5.p1;

import org.junit.jupiter.api.*;

//Juint5几个常用注解的使用
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CalculatorTest {
    @BeforeAll
    public static void init() {
        System.out.println("BeforeAll--->初始化数据");
    }

    @AfterAll
    public static void cleanup() {
        System.out.println("@AfterAll--->清理数据");
    }

    @BeforeEach
    public void beforeMethod(){
        System.out.println("beforeMethod");
    }

    @AfterEach
    public void afterMethod(){
        System.out.println("afterMethod");
    }

    @Test
    @Order(2)
    public void testAdd() {
        System.out.println("testAdd 方法开始测试");
    }

    @Test
    @Order(1)
    public void testDiv() {
        System.out.println("testDiv 方法开始测试");
    }

    @Test
    @Disabled
    public void testString() {
        System.out.println("testString 方法开始测试");
    }

    @DisplayName("重复测试")
    @RepeatedTest(value = 3)
    public void testRepeated() {
        System.out.println("testRepeated 方法开始测试");
    }

}
