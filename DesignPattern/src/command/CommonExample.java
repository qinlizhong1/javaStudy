package command;

//程序员类
class Coder0 {
    private String name;

    public Coder0(String name) {
        this.name = name;
    }

    public void doSomething(){
        System.out.println(name + " 编写代码");
    }
}

//测试人员类
class Tester0 {
    private String name;

    public Tester0(String name) {
        this.name = name;
    }

    public void doSomething(){
        System.out.println(name + " 遍写测试用例");
    }
}

//UI设计人员类
class UIDesigner0{
    private String name;

    public UIDesigner0(String name) {
        this.name = name;
    }

    public void doSomething(){
        System.out.println(name + " 设计UI");
    }
}


public class CommonExample {
    public static void main(String[] args) {
        //客户端新增需求,需要分别告知程序员、测试、设计
        Coder0 coder0 = new Coder0("程序员张三");
        Tester0 tester0 = new Tester0("测试 李四");
        UIDesigner0 uiDesigner0 = new UIDesigner0("设计王五");

        coder0.doSomething();
        tester0.doSomething();
        uiDesigner0.doSomething();
    }
}
