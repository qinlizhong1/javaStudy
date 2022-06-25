package thread.base;

//1.实现Runnable接口
class MyRunnable implements Runnable{
    //2.重新run方法
    @Override
    public void run(){
        System.out.println("I am thread:" + Thread.currentThread().getName());
    }
}

public class CreateThreadExample1 {
    public static void main(String[] args) {
        //3.创建实现类的对象
        Runnable runnable = new MyRunnable();
        //4.创建一个Thread类
        Thread thread = new Thread(runnable);
        //5.通过Thread类的对象调用start()方法
        thread.start();
        System.out.println("I am thread:" + Thread.currentThread().getName());
    }
}
