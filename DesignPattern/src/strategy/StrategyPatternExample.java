package strategy;

//1 定义一个策略接口，定义计算方法的操作
interface CalculateStrategy {
    double calculator(double price);
}

//2.1 实现各个算法：普通用户的计算方法
class CommonUserCalculateStrategy implements CalculateStrategy{
    @Override
    public double calculator(double price) {
        return price;
    }
}

//2.2 实现各个算法：普通会员的计算方法
class CommonMemberCalculateStrategy implements CalculateStrategy{
    @Override
    public double calculator(double price) {
        return price * 0.9;
    }
}

//2.3 实现各个算法：超级会员的计算方法
class SuperMemberCalculateStrategy implements CalculateStrategy{
    @Override
    public double calculator(double price) {
        return price * 0.7;
    }
}

//3 定义上下文类,所谓上下文类，就是集成算法的类。
class StrategyContext{
    private CalculateStrategy  calculateStrategy;

    public StrategyContext(CalculateStrategy calculateStrategy) {
        this.calculateStrategy = calculateStrategy;
    }

    public double calculatorRealAmount(double price){
        return calculateStrategy.calculator(price);
    }
}


public class StrategyPatternExample {
    public static void main(String[] args) {
        StrategyContext  commonUser  = new StrategyContext(new CommonUserCalculateStrategy());
        System.out.println("普通用户实际支付金额：" + commonUser.calculatorRealAmount(100));

        StrategyContext  commonMember  = new StrategyContext(new CommonMemberCalculateStrategy());
        System.out.println("普通会员实际支付金额：" + commonMember.calculatorRealAmount(100));

        StrategyContext  SuperMember  = new StrategyContext(new SuperMemberCalculateStrategy());
        System.out.println("超级会员实际支付金额：" + SuperMember.calculatorRealAmount(100));
    }
}
