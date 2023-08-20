package template;

//麻将类
abstract class Mahjong{
    //final方法，定义了算法的骨架
    public final void playMahjong(){
        login();
        play();
        logout();
    }

    private void login(){
        System.out.println("登录游戏！");
    }

    private void logout(){
        System.out.println("退出游戏！");
    }

    //抽象方法，由其子类实现
    public abstract void play();
}

//湖南麻将类
class HunanMahjong extends Mahjong{
    @Override
    public void play() {
        System.out.println("湖南麻将进行中");
    }
}

//广东麻将类
class GuangdongMahjong extends Mahjong{
    @Override
    public void play() {
        System.out.println("广东麻将进行中");
    }
}


public class TemplateMethodExample {
    public static void main(String[] args) {
        Mahjong hunanMahjong = new HunanMahjong();
        hunanMahjong.playMahjong();

        System.out.println();
        Mahjong guangdongMahjong = new GuangdongMahjong();
        guangdongMahjong.playMahjong();
    }
}
