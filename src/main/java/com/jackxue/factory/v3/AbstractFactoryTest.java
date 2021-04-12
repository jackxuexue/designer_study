package com.jackxue.factory.v3;

/**
 * 可以很好的扩展产品簇，但是扩展产品很难
 */
public class AbstractFactoryTest {
    public static void main(String[] args) {
//        AbstractFactory f1 = new HuaweiFactory();
        AbstractFactory f1 = new XiaomiFactory();
        f1.createProductA().showA();
        f1.createProductB().ShowB();
    }
}

interface ProductA{
    void showA();
}

interface ProductB{
    void ShowB();
}

/**
 * 抽象工厂用于实现某一个产品簇的工厂
 */
abstract class AbstractFactory{
    abstract ProductA createProductA();
    abstract ProductB createProductB();
}

/**
 * 具体工厂
 */
class HuaweiFactory extends AbstractFactory{
    @Override
    ProductA createProductA() {
        return new HuaWeiPhone();
    }

    @Override
    ProductB createProductB() {
        return new HuaWeiPad();
    }
}
class XiaomiFactory extends AbstractFactory{
    @Override
    ProductA createProductA() {
        return new XiaomiPhone();
    }

    @Override
    ProductB createProductB() {
        return new XiaomiPad();
    }
}

/** 具体产品*/
class HuaWeiPhone implements ProductA{
    @Override
    public void showA() {
        System.out.println("华为手机！");
    }
}
class XiaomiPhone implements ProductA{
    @Override
    public void showA() {
        System.out.println("小米手机！");
    }
}
class HuaWeiPad implements ProductB{
    @Override
    public void ShowB() {
        System.out.println("华为平板！");
    }
}
class XiaomiPad implements ProductB{
    @Override
    public void ShowB() {
        System.out.println("小米平板！");
    }
}
