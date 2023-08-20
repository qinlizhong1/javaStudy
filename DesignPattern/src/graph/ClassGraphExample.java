package graph;

class Student{
    public String pubVar;
    protected String proVar;
    private String priVar;
    String defaultVar;

    public String pubFun(){
        return "pubFun";
    }
    protected String proFun(){
        return "proFun";
    }
    private String priFun()
    {
        return "priFun";
    }
    String defaultFun(){
        return "defaultFun";
    }
}

abstract class Person{
    public String pubVar;
    protected String proVar;
    private String priVar;
    String defaultVar;

    public String pubFun(){
        return "pubFun";
    }
    protected String proFun(){
        return "proFun";
    }
    private String priFun()
    {
        return "priFun";
    }
    String defaultFun(){
        return "defaultFun";
    }

    public abstract void abstractFun();
}



class Parent{

}

class Son extends Parent{

}



interface Animal{

}

class Dog implements Animal{

}




class Department{
    private Employee employee;
}

class Employee{

}





class Mouth
{

}

class Head {
    private Mouth mouth;
}


class Screwdriver{

}

class Worker{
    //Screwdriver对象作为Worker类方法的参数，构成依赖关系
    public void screw(Screwdriver screwdriver){

    }
}



interface Shoes{
    void abstractFun();
}

public class ClassGraphExample {
}
