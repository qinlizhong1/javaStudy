package memo;

import java.util.ArrayList;
import java.util.List;

//1、创建备忘录类,备忘录类只包含要保存的数据,这里是游戏等级
class GameMemento{
    private int level;

    public GameMemento(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }
}

//2、角色类，备忘录模式就是要完成保存状态，然后恢复状态的功能。那么保存和恢复谁的状态呢？对了，就是这个角色的状态。
class GameOriginator {
    private int currentLevel;

    //创建备忘录，对外提供备忘录，
    public GameMemento createGameMemento(){
        return new GameMemento(currentLevel);
    }

    //从外部接收备忘录用于恢复状态
    void restoreFromMemento(GameMemento gameMemento)
    {
        currentLevel =  gameMemento.getLevel();
    }

    //对内部状态的使用
    public void playGame() {
        System.out.println("------------------开始游戏------------------");
        System.out.println("上次退出时游戏级别为："+ currentLevel);
        System.out.println("玩了4个小时，升了1级");
        currentLevel++;
        System.out.println("当前游戏级别为："+ currentLevel);
    }

    public void exitGame(){
        System.out.println("退出游戏");
        currentLevel=0;
        System.out.println("-----------------退出游戏-------------------\n");
    }

}

//3、创建GameCareTaker管理者类，负责保存和恢复Originator的状态，状态是保存在这类里面的。
class GameCareTaker {
    private List<GameMemento> memento= new ArrayList<>();

    public void saveMemento(GameMemento memento) {
        this.memento.add(memento);
    }

    public GameMemento getMemento(int index) {
        return this.memento.get(index);
    }
}

public class MemoExample {
    public static void main(String[] args) {
        GameOriginator originator = new GameOriginator();
        GameCareTaker careTaker = new GameCareTaker();

        //玩游戏
        originator.playGame();
        //保存进度
        careTaker.saveMemento(originator.createGameMemento());
        //退出游戏
        originator.exitGame();

        //重新打开游戏，恢复进度
        originator.restoreFromMemento(careTaker.getMemento(0));
        originator.playGame();
    }
}
