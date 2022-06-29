package factory;
/*
//1.定义鞋这种产品的抽象基类
abstract class Shoes{
    public abstract void showLogo();
}

//2.定义具体品牌的鞋类，继承鞋抽象基类
class NikeShoes extends Shoes{

    @Override
    public void showLogo() {
        System.out.println("我是耐克鞋子");
    }
}

//2.定义具体品牌的鞋类，继承鞋抽象基类
class AdidasShoes extends Shoes{

    @Override
    public void showLogo() {
        System.out.println("我是阿迪鞋子");
    }
}

//新增加安踏品牌，需要新增加有一个安踏鞋类继承抽象基类
class AntaShoes extends Shoes{

    @Override
    public void showLogo() {
        System.out.println("我是安踏鞋子");
    }
}

//3.定义简单工厂方法类，使用一个静态工厂方法来根据不同的品牌条件来产生不同品牌的鞋
class SimpleFactory {
    public static Shoes makeShoes(String brand){
        Shoes shoes = null;
        switch (brand){
            case "nike":
                shoes = new NikeShoes();
                break;
            case "adidas":
                shoes = new AdidasShoes();
                break;
            case "anta":
                shoes = new AntaShoes();
                break;
            default:
                System.out.println("错误的品牌");
        }
        return shoes;
    }
}

//简单工厂模式
public class SimpleFactoryExample{
    public static void main(String[] args) {
        //使用工厂模式创建耐克品牌的鞋子
        Shoes nikeShoes = SimpleFactory.makeShoes("nike");
        nikeShoes.showLogo();

        //使用工厂模式创建阿迪品牌的鞋子
        Shoes adidasShoes = SimpleFactory.makeShoes("adidas");
        adidasShoes.showLogo();
    }
}
*/