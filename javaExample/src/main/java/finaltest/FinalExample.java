package finaltest;
/*
final class A{

}

//编译不过，被final修饰的类不能被继承
class B extends A{

}
*/

/*
class C {
    public final void fun(){

    }
}

//编译不过，被final修饰的方法不能被重写
class D extends C {
    @Override
    public void fun() {

    }
}
*/

/*
//编译不过，构造函数不能被final修饰
class E{
    final E(){

    }
}
*/

class Father{
    private final void fun(){
        System.out.println("Father fun");
    }
}

class Son extends Father{
    private void fun(){
        System.out.println("Son fun");
    }
}

public class FinalExample {
    Son son = new Son();


}
