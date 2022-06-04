package reflection;

public class Father {
    public int fatherPublicVar;
    protected int fatherProtectedVar;
    private int fatherPrivateVar;

    public String fatherPublicFun() {
        return "父类公有方法fatherPublicFun";
    }

    protected String fatherProtectedFun() {
        return "父类保护方法fatherProtectedFun";
    }

    private String fatherPrivateFun() {
        return "父类保护方法fatherPrivateFun";
    }
}

class Son extends Father{
    public int sonPublicVar;
    protected int sonProtectedVar;
    private int sonPrivateVar;

    public String sonPublicFun() {
        return "子类公有方法sonPublicFun";
    }

    protected String sonProtectedFun() {
        return "子类保护方法sonProtectedFun";
    }

    private String sonPrivateFun(String arg) {
        return "子类保护方法sonPrivateFun"  + arg;
    }

    public int getSonPrivateVar() {
        return sonPrivateVar;
    }
}