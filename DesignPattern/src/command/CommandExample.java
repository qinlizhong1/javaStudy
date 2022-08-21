package command;

import java.util.ArrayList;
import java.util.List;

//1、命令接口，所有具体的命令都会实现此接口，
interface Command {
    void execute();
}

//2、构建具体执行命令的角色类，这里分别是程序员、测试人员、UI设计人员
//程序员类
class Coder {
    private String name;

    public Coder(String name) {
        this.name = name;
    }

    public void doSomething(){
        System.out.println(name + " 编写代码");
    }
}

//测试人员类
class Tester {
    private String name;

    public Tester(String name) {
        this.name = name;
    }

    public void doSomething(){
        System.out.println(name + " 遍写测试用例");
    }
}

//UI设计人员类
class UIDesigner{
    private String name;

    public UIDesigner(String name) {
        this.name = name;
    }

    public void doSomething(){
        System.out.println(name + " 设计UI");
    }
}



//3、构建各种具体的命令
//3.1 修改代码的命令类
class CodeCommand implements Command{
    private Coder coder;

    public CodeCommand(Coder coder) {
        this.coder = coder;
    }

    @Override
    public void execute() {
        coder.doSomething();
    }
}

//3.2 修改测试用例的命令类
class TestCommand implements Command{
    private Tester tester;

    public TestCommand(Tester tester ) {
        this.tester = tester ;
    }

    @Override
    public void execute() {
        tester.doSomething();
    }
}

//3.3 修改需求文档的命令类
class ModifyRequirementCommand implements Command{
    private UIDesigner uiDesigner;

    public ModifyRequirementCommand(UIDesigner uiDesigner) {
        this.uiDesigner = uiDesigner;
    }

    @Override
    public void execute() {
        uiDesigner.doSomething();
    }
}

//4 创建命令的调用者类（Invoker）,这里是项目经理类SM
class PM{
    private final List<Command> commands = new ArrayList<>();

    //设置一套命令，不知道具体执行者是谁
    public void addCommands(Command command) {
        commands.add(command);
    }

    //执行系列命令
    public void executeCommand() {
        for (Command command : commands) {
            command.execute();
        }
    }
}

//客户端使用
public class CommandExample {
    public static void main(String[] args) {
        //客户通过项目经理发出命令
        PM pm = new PM();

        CodeCommand codeCommand = new CodeCommand(new Coder("程序员张三"));
        TestCommand testCommand =  new TestCommand(new Tester("测试李四"));
        ModifyRequirementCommand modifyRequirementCommand = new ModifyRequirementCommand(new UIDesigner("设计王五"));

        pm.addCommands(codeCommand);
        pm.addCommands(testCommand);
        pm.addCommands(modifyRequirementCommand);

        pm.executeCommand();
    }
}