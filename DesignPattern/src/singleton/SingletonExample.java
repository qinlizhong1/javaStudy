package singleton;

//懒汉式，线程不安全
 class Singleton1{
     private static  Singleton1 instance;

     //构造函数定义为私有，防止外部创建实例
     private Singleton1(){

     }

     //系统使用单例的入口
     public static Singleton1 getInstance(){
         if (null == instance){
             instance = new Singleton1();
         }

         return instance;
     }
 }

//懒汉式，线程安全，效率低
class Singleton2{
    private static  Singleton2 instance;

    //构造函数定义为私有，防止外部创建实例
    private Singleton2(){

    }

    //系统使用单例的入口
    public static synchronized Singleton2 getInstance(){
        if (null == instance){
            instance = new Singleton2();
        }

        return instance;
    }
}

//懒汉式，线程不安全
class Singleton3{
    private static  Singleton3 instance;

    //构造函数定义为私有，防止外部创建实例
    private Singleton3(){

    }

    //系统使用单例的入口
    public static Singleton3 getInstance(){
        if (null == instance){
            synchronized(Singleton3.class) {
                instance = new Singleton3();
            }
        }

        return instance;
    }
}

//懒汉式，线程安全，效率还可以
class Singleton4{
     //注意加上volatile关键字
    private static  volatile Singleton4 instance;

    //构造函数定义为私有，防止外部创建实例
    private Singleton4(){

    }

    //系统使用单例的入口
    public static Singleton4 getInstance(){
        //第一次检查提高访问性能
        if (null == instance){
            synchronized(Singleton4.class) {
                //第二次检查为了线程安全
                if(instance ==null) {
                    instance = new Singleton4();
                }
            }
        }

        return instance;
    }
}

//饿汉式，线程安全
class Singleton5{
     //
    private static final Singleton5 INSTANCE = new Singleton5();

    //构造函数定义为私有，防止外部创建实例
    private Singleton5(){

    }

    //系统使用单例的入口
    public static Singleton5 getInstance(){
        return INSTANCE;
    }
}

public class SingletonExample {
    public static void main(String[] args) {

    }
}
