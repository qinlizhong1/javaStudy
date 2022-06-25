package thread.base;

import jdk.swing.interop.SwingInterOpUtils;

class Counter{
    private int count = 0;

    public void increment(){
        count++;
    }

    public int getCount(){
        return count;
    }
}

class MyThreads extends Thread{
    private Counter counter = new Counter();
    @Override
    public void run(){
        for (int i=0; i<100; i++){
            counter.increment();
        }
        System.out.println("MyThreads count:" + counter.getCount());
        System.out.println("MyThreads counter hashcode:" + counter.hashCode());
    }

}

class MyRunnables implements Runnable{
    private Counter counter = new Counter();
    @Override
    public void run(){
        for (int i=0; i<100; i++){
            counter.increment();
        }
        System.out.println("MyRunnables count:" + counter.getCount());
        System.out.println("MyRunnables counter hashcode:" + counter.hashCode());
    }

}

public class ThreadCreateCmpExample {
    public static void main(String[] args) {
        Thread t;
        for (int i=0; i<4; i++){
            t = new MyThreads();
            t.start();
        }

        Runnable runnable = new MyRunnables();
        for (int i=0; i<4; i++){
            t = new Thread(runnable);
            t.start();
        }

    }
}
