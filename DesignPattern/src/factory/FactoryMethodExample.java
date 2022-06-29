package factory;

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

//新增加安踏品牌，需要新增加有一个安踏鞋类继承抽象基类
class AntaShoes extends Shoes{

    @Override
    public void showLogo() {
        System.out.println("我是安踏鞋子");
    }
}

//2.定义具体品牌的鞋类，继承鞋抽象基类
class AdidasShoes extends Shoes{

    @Override
    public void showLogo() {
        System.out.println("我是阿迪鞋子");
    }
}

//3.定义工厂类接口
interface ShoesFactory {
    public abstract Shoes makeShoes();
}

//4.定义具体产品工厂类，如生成耐克鞋的工厂
class NikeShoesFactory implements ShoesFactory{
    @Override
    public Shoes makeShoes() {
        return new NikeShoes();
    }
}

//4.定义具体产品工厂类，如生成阿迪鞋的工厂
class AdidasShoesFactory implements ShoesFactory{
    @Override
    public Shoes makeShoes() {
        return new AdidasShoes();
    }
}

//改动2.新增一个生产安踏鞋的工厂类，其实现了抽象工厂基类
class AntaShoesFactory implements ShoesFactory{
    @Override
    public Shoes makeShoes() {
        return new AntaShoes();
    }
}


//工厂方法模式
public class FactoryMethodExample {
    public static void main(String[] args) {
        NikeShoesFactory nikeShoesFactory = new NikeShoesFactory();
        nikeShoesFactory.makeShoes().showLogo();

        AdidasShoesFactory adidasShoesFactory = new AdidasShoesFactory();
        adidasShoesFactory.makeShoes().showLogo();
    }
}
