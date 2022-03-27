package java8.functionalinterface;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * 内置最常用的四种函数式接口
 */
class FunctionalnterfaceTest{
    public void test0(){
        System.out.println("-----------------------------------test0()-----------------------------------");
        Consumer<String> consumer = s -> System.out.println("[Consumer<T>]--->" + s);
        consumer.accept("hello");
    }

    public void test1() {
        System.out.println("\n-----------------------------------test1()-----------------------------------");
        Supplier<String> supplier = () ->  "hello";
        System.out.println("[Supplier<T>]--->" + supplier.get());
    }

    public void test2() {
        System.out.println("\n-----------------------------------test2()-----------------------------------");
        Predicate<String> predicate = s -> s.equals("hello");
        System.out.println("[Predicate<T>]--->" + predicate.test("hello"));
    }

    public void test3() {
        System.out.println("\n-----------------------------------test3()-----------------------------------");
        Function<String, String> function = (s) -> {
            return "hello" + s;
        };
        System.out.println("[Function<T, R>]--->" + function.apply("666"));
    }
}

public class FunctionalnterfaceExample {
    public static void main(String[] args) {
        FunctionalnterfaceTest functionalnterfaceTest = new FunctionalnterfaceTest();
        functionalnterfaceTest.test0();
        functionalnterfaceTest.test1();
        functionalnterfaceTest.test2();
        functionalnterfaceTest.test3();
    }
}
