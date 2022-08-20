package wrapperClass;

class WrapperClassTest {
    //装箱
    public void test0() {
        System.out.println("----------------------------------------------------------------test0()----------------------------------------------------------------");
        Integer integer = new Integer(3); //该方法是过期方法，尽量不用
        Integer integer1 = new Integer("4"); //该方法是过期方法，尽量不用
        Integer integer2 = Integer.valueOf(5); //
        Integer integer3 = Integer.valueOf("6"); //
        Integer integer4 = 7; //自动装箱
        System.out.println(integer);
        System.out.println(integer1);
        System.out.println(integer2);
        System.out.println(integer3);
        System.out.println(integer4);
    }

    //拆箱
    public void test1() {
        System.out.println("\n\n----------------------------------------------------------------test1()----------------------------------------------------------------");
        Integer integer = Integer.valueOf(88);
        int a = integer.intValue();
        int b = integer;
        System.out.println(a);
        System.out.println(b);
    }

    //基本数据类型、包装类转换为String
    public void test2(){
        System.out.println("\n\n----------------------------------------------------------------test2()----------------------------------------------------------------");
        String s = String.valueOf(123);

        Integer integer = Integer.valueOf(888);
        String s1 = String.valueOf(integer);

        System.out.println(s);
        System.out.println(s1);
    }

    public void test3(){
        System.out.println("\n\n----------------------------------------------------------------test3()----------------------------------------------------------------");
        int a = Integer.parseInt("123");
        //运行报错java.lang.NumberFormatException: For input string: "123a"
        //int b = Integer.parseInt("123a");

        boolean c = Boolean.parseBoolean("true");
        boolean d = Boolean.parseBoolean("trueaa");
        System.out.println(a);
        //System.out.println(b);
        System.out.println(c);
        System.out.println(d);
    }
}

public class WrapperClassExample {
    public static void main(String[] args) {
        WrapperClassTest wrapperClassTest = new WrapperClassTest();
        wrapperClassTest.test0();
        wrapperClassTest.test1();
        wrapperClassTest.test2();
        wrapperClassTest.test3();
    }
}
