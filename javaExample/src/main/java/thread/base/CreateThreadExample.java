package thread.base;

class MyThread extends Thread{
    @Override
    public void run(){
        System.out.println("I am thread:" + Thread.currentThread().getName());
    }
}

public class CreateThreadExample {
    public static void main(String[] args) {
        Thread thread = new MyThread();
        thread.start();
        System.out.println("I am thread:" + Thread.currentThread().getName());
    }
}
