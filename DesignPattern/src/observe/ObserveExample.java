package observe;

import java.util.ArrayList;
import java.util.List;

//1 定义一个观察者接口，观察者接收到通知就是在这些方法里面进行相应的动作。
interface FanObserver{
    void publish();
    void delete();
}


//2.1 针对张三这个粉丝实现观察者接口，多少个粉丝就有多少个实现类
class ZhangSanFanObserver implements FanObserver{
    private String name;

    public ZhangSanFanObserver(String name) {
        this.name = name;
    }


    @Override
    public void publish() {
        System.out.println(name + "  可以阅读文章");
    }

    @Override
    public void delete() {
        System.out.println(name + "  不能阅读文章");
    }
}

//2.2 针对李四这个粉丝实现观察者接口，多少个粉丝就有多少个实现类
class LisiFanObserver implements FanObserver{
    private String name;

    public LisiFanObserver(String name) {
        this.name = name;
    }

    @Override
    public void publish() {
        System.out.println(name + "  可以阅读文章");
    }

    @Override
    public void delete() {
        System.out.println(name + "  不能阅读文章");
    }
}

//3 定义被观察者接口，这里的被观察者是公众号，接口包含3个方法
//follow方法:关注
//unfollow方法：取消关注
//notifyState方法：当状态发生改变时，用来通知其观察者
interface Subject{
    void add(FanObserver observer);
    void remove(FanObserver observer);
    void notifyState(String state);
}
//4 定义观察者接口的实现类，并实现接口方法；实现类接口持有观察者的FanObserver的集合
class OfficialAccountSubject implements Subject{
    private List<FanObserver> fanDogObservers = new ArrayList<>();
    @Override
    public void add(FanObserver observer) {
        fanDogObservers.add(observer);
    }

    @Override
    public void remove(FanObserver observer) {
        fanDogObservers.remove(observer);
    }

    @Override
    public void notifyState(String state) {
        for (FanObserver fanDogObserver : fanDogObservers){
            if (state.equals("发布文章")){
                fanDogObserver.publish();
            }else if(state.equals("删除文章")){
                fanDogObserver.delete();
            }
        }
    }
}


public class ObserveExample {
    public static void main(String[] args) {
        OfficialAccountSubject officialAccountSubject = new OfficialAccountSubject();

        ZhangSanFanObserver zhangSanFanObserver = new ZhangSanFanObserver("张三");
        LisiFanObserver lisiFanObserver = new LisiFanObserver("李四");

        officialAccountSubject.add(zhangSanFanObserver);
        officialAccountSubject.add(lisiFanObserver);
        System.out.println("公众号发布了一篇文章：");
        officialAccountSubject.notifyState("发布文章");
        System.out.println();
        System.out.println("公众号删除了一篇文章：");
        officialAccountSubject.notifyState("删除文章");
    }
}
