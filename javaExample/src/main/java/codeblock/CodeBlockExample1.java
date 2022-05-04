package codeblock;
//执行顺序(优先级从高到低)：静态代码块 > mian()方法 > 构造代码块 > 构造方法 > 局部代码块。其中静态代码块只执行一次。构造代码块和局部代码块再每次创建对象是都会执行。
public class CodeBlockExample1 {
    static {
        System.out.println("静态代码块...");
    }

    {
        System.out.println("构造代码块...");
    }

    public CodeBlockExample1() {
        System.out.println("无参构造器...");
    }

    public static void main(String[] args) {
        System.out.println("main()方法运行");
        CodeBlockExample1 codeBlockExample1 = new CodeBlockExample1();
        System.out.println("-----------------------------------------");
        CodeBlockExample1 codeBlockExample2 = new CodeBlockExample1();
    }
}
