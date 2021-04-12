package com.jackxue.factory.v1;

public class SimpleFactoryTest {
    public static void main(String[] args) {
        SimpleFactory.makeProduct(1).print();
        SimpleFactory.makeProduct(2).print();
    }
}

interface Product{
    void print();
}

class KeyBoard implements Product{
    @Override
    public void print() {
        System.out.println("这是一个键盘！");
    }
}

class Mouse implements Product{
    @Override
    public void print() {
        System.out.println("这是一个鼠标！");
    }
}

class SimpleFactory{
    private SimpleFactory instance = new SimpleFactory();

    private SimpleFactory(){}
    public static Product makeProduct(int type){
        switch (type){
            case 1:
                return new KeyBoard();
            case 2:
                return new Mouse();
        }
        return null;
    }
}
