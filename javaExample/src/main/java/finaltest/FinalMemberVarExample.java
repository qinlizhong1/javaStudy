package finaltest;

class FinalMemberVarTest{
    //在声明final变量的等号右边直接赋值
    final int a = 10;

    //构造函数赋值
    final int b;
    FinalMemberVarTest(){
        b = 20;
    }

    //构造代码块中赋值
    final int c;
    {
        c = 30;
    }

    public void test(){
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("c = " + c);
    }
}

class FinalStaticMemberVarTest{
    //在声明final变量的等号右边直接赋值
    static final int a = 11;

    //静态代码块中赋值
    static final int b;
    static {
        b = 22;
    }

    public void test(){
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }
}

public class FinalMemberVarExample {
    public static void main(String[] args) {
        FinalMemberVarTest finalMemberVarTest = new FinalMemberVarTest();
        finalMemberVarTest.test();

        FinalStaticMemberVarTest finalStaticMemberVarTest = new FinalStaticMemberVarTest();
        finalStaticMemberVarTest.test();
    }
}
