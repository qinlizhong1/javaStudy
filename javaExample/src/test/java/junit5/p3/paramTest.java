package junit5.p3;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class paramTest {

    //@ParameterizedTest 作为参数化测试的必要注解，替代了 @Test 注解。任何一个参数化测试方法都需要标记上该注解。
    //@ValueSource 是 JUnit 5 提供的最简单的数据参数源，支持 Java 的八大基本类型和字符串，Class，使用时赋值给注解上对应类型属性，以数组方式传递，
    @ParameterizedTest
    @ValueSource(ints = {2, 4, 8})
    void testNumberShouldBeEven(int num) {
        Assertions.assertEquals(0, num % 2);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Effective Java", "Code Complete", "Clean Code"})
    void testPrintTitle(String title) {
        System.out.println(title);
    }

    // @CsvSource 可以注入指定 CSV 格式 (comma-separated-values) 的一组数据，用每个逗号分隔的值来匹配一个测试方法对应的参数。
    @ParameterizedTest
    @CsvSource({"1,One", "2,Two", "3,Three"})
    void testDataFromCsv(long id, String name) {
        System.out.printf("id: %d, name: %s", id, name);
    }

    // @CsvSource 可以注入指定 CSV 格式 (comma-separated-values) 的一组数据，用每个逗号分隔的值来匹配一个测试方法对应的参数。
    //除了用逗号分隔参数外，@CsvSource 还支持自定义符号，只要修改它的 delimiter 即可，默认为,
    @ParameterizedTest
    @CsvSource(value = {"1:One", "2:Two", "3:Three", "4:forth"}, delimiterString = ":")
    void testDataFromCsvSelfDelimiter (long id, String name) {
        System.out.printf("id: %d, name: %s", id, name);
    }

}
