package inherit;

interface MyInterface{
    //接口成员变量(前面默认加了public static final)
    double PI  = 3.14;

    //接口抽象方法(前面默认加了public abstract)
    void abstractMethodFun();

    //jdk1.8后接口中支持静态方法
    static void staticFun(){
        System.out.println("接口static方法.");
    }

    //jdk1.8后接口中支持默认方法
    default void defaultFun(){
        System.out.println("接口default方法.");
    }

    //jdk1.9后接口中支持私有方法
    private void privateFun(){
        System.out.println("接口private方法.");
    }
}

class MyClass implements MyInterface{
    //接口的抽象方法一定要在子类中重写
    @Override
    public void abstractMethodFun() {
        System.out.println("实现类中实现了接口的abstractMethodFun方法");
    }

    //接口中的default方法可以重写也可以不重写
}

class InterfaceTest{
    /* 接口不能示例化
    public void test0(){
        //编译报错：cannot be instantiated
        MyInterface myInterface = new MyInterface();
    }
    */

    public void test1(){
        MyClass myClass = new MyClass();
        myClass.abstractMethodFun();
        myClass.defaultFun();
        MyInterface.staticFun();
    }
}



public class InterfaceExample {
    public static void main(String[] args) {
        InterfaceTest interfaceTest = new InterfaceTest();
        interfaceTest.test1();
    }
}
