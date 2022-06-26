package inherit;

abstract class Animal {
    //抽象类可以有构造器
    public Animal() {
    }

    //抽象方法
    public abstract void eat();

    //普通方法
    public void sleep() {
        System.out.println("动物睡觉...");
    }
}

class Dog extends Animal{
    //抽象类的抽象方法一定要在非抽象子类中重写
    @Override
    public void eat() {
        System.out.println("狗吃骨头");
    }
}

class AbstractClassTest{
    /*
    public void test0(){
       //抽象类不能示例化，编译报错
        Animal animal = new Animal();
    }
    */

    public void test1(){
        Dog dog = new Dog();
        dog.eat();
        dog.sleep();
    }
}

public class AbstractClassExample {
    public static void main(String[] args) {
        AbstractClassTest abstractClassTest = new AbstractClassTest();
        abstractClassTest.test1();
    }
}
