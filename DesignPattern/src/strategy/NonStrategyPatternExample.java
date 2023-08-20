package strategy;

enum Grade{
    COMMON_USER,    //普通用户
    COMMON_MEMBER,  //普通会员
    SUPER_MEMBER    //超级会员

}

class CalculatorRealAmount{
    public double calculator(double price, Grade grade){
        double realAmount = 0.0;

        if (grade == Grade.COMMON_USER){
            realAmount = price;
        }else if(grade == Grade.COMMON_MEMBER){
            realAmount = price * 0.9;
        }else if (grade == Grade.SUPER_MEMBER){
            realAmount = price * 0.7;
        }else{
            System.out.println("不支持的会员等级");
        }

        return realAmount;
    }
}


public class NonStrategyPatternExample {
    public static void main(String[] args) {
        CalculatorRealAmount calculatorRealAmount = new CalculatorRealAmount();
        System.out.println(calculatorRealAmount.calculator(100, Grade.COMMON_USER));
        System.out.println(calculatorRealAmount.calculator(100, Grade.COMMON_MEMBER));
        System.out.println(calculatorRealAmount.calculator(100, Grade.SUPER_MEMBER));
    }
}
