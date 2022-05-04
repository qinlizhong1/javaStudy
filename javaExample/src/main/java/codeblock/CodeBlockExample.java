package codeblock;

class A{
    //构造代码块
    {
        System.out.println("构造代码块1");
    }

    A(){
        System.out.println("A的无参构造函数");
    }

    //构造代码块
    {
        System.out.println("构造代码块2");
    }
}

class Father{
    //父类静态代码块
    static {
        System.out.println("Father类静态代码块1");
    }

    Father(){
        System.out.println("Father类无参构造函数");
    }

    //父类静态代码块
    static {
        System.out.println("Father类静态代码块2");
    }
}

class Son extends Father{
    //子类静态代码块
    static {
        System.out.println("Son类静态代码块1");
    }

    Son(){
        System.out.println("Son类无参构造函数");
    }

    //子类静态代码块
    static {
        System.out.println("Son类静态代码块2");
    }
}

class CodeBlockTest{
    //普通代码块
    public void test0(){
        System.out.println("----------------------------------------------------------------test0()----------------------------------------------------------------");
        int x = 10;
        {
            x = 18;
            System.out.println("【0】x=" + x); //18
            int y = 20;
            System.out.println("【1】y=" + y); //20
            int z = 30;
            System.out.println("【2】z=" + z); //30
        }
        int y = 40;
        System.out.println("【3】x=" + x); //18
        System.out.println("【4】y=" + y); //40
        {
            int z = 50;
            System.out.println("【5】z=" + z); //50
        }
    }

    //构造代码块
    public void test1(){
        System.out.println("\n\n----------------------------------------------------------------test1()----------------------------------------------------------------");
        A a1 = new A();
        System.out.println("-----------------------------------------");
        A a2 = new A();
    }

    public void test2(){
        System.out.println("\n\n----------------------------------------------------------------test2()----------------------------------------------------------------");
        Son son1 = new Son();
        System.out.println("-----------------------------------------");
        Son son2 = new Son();
    }

    public void test3(){
        System.out.println("\n\n----------------------------------------------------------------test3()----------------------------------------------------------------");
    }

    public void test4(){
        System.out.println("\n\n----------------------------------------------------------------test4()----------------------------------------------------------------");
    }
}

public class CodeBlockExample {
    public static void main(String[] args) {
        CodeBlockTest codeBlockTest = new CodeBlockTest();
        codeBlockTest.test0();
        codeBlockTest.test1();
        codeBlockTest.test2();
        codeBlockTest.test3();
        codeBlockTest.test4();
    }
}
