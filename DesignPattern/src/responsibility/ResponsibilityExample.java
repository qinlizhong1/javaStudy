package responsibility;

//1.定义一个所有层级请假处理器都需要实现的接口
interface AskForLeaveHander{
    void setNextHandler(AskForLeaveHander nextHandler);
    boolean handler(int days);
}

//2.1 组长批复类
class HeadmanHander  implements AskForLeaveHander{
    private AskForLeaveHander nextHandler;

    @Override
    public void setNextHandler(AskForLeaveHander nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public boolean handler(int days) {
        if (days <= 3){
            System.out.println("组长成功批复了！");
            return true;
        }

        System.out.println(String.format("%d 天假期超出组长权限,请总监批复",days));
        return nextHandler.handler(days);
    }
}

//2.2 总监批复类
class ChiefHander  implements AskForLeaveHander{
    private AskForLeaveHander nextHandler;

    @Override
    public void setNextHandler(AskForLeaveHander nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public boolean handler(int days) {
        if (days <= 7){
            System.out.println("总监成功批复了！");
            return true;
        }

        System.out.println(String.format("%d 天假期超出总监权限,请总经理批复", days));
        return nextHandler.handler(days);
    }
}

//2.3 总经理批复类
class GmHander  implements AskForLeaveHander{
    private AskForLeaveHander nextHandler;

    @Override
    public void setNextHandler(AskForLeaveHander nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public boolean handler(int days) {
        if (days <= 60){
            System.out.println("总经理成功批复了！");
            return true;
        }

        System.out.println("单次最多只能请60天假！");
        return false;
    }
}

public class ResponsibilityExample {
    public static void main(String[] args) {
        HeadmanHander headmanHander = new HeadmanHander();
        ChiefHander chiefHander = new ChiefHander();
        GmHander gmHander =  new GmHander();

        headmanHander.setNextHandler(chiefHander);
        chiefHander.setNextHandler(gmHander);

        System.out.println("小二哥申请15天假期\n");
        if (headmanHander.handler(15)){
            System.out.println("\n您申请的假期已被批准");
        }else{
            System.out.println("\n最近项目太忙了，暂不批假");
        }
    }
}
