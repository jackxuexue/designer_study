package com.jackxue.factory.v2;

public class FactoryMethod {
    public static void main(String[] args) {
        ProductFactory f1 = new KeyBoardFactory();
        f1.createProduct().show();

        f1 = new CpuFactory();
        f1.createProduct().show();
    }
}

interface Product{
    void show();
}

interface ProductFactory{
    Product createProduct();
}

class KeyBoard implements Product{

    @Override
    public void show() {
        System.out.println("keyboard!");
    }
}

class Cpu implements Product{
    @Override
    public void show() {
        System.out.println("Cpu!");
    }
}

class KeyBoardFactory implements ProductFactory{
    @Override
    public Product createProduct() {
        return new KeyBoard();
    }
}

class CpuFactory implements ProductFactory{
    @Override
    public Product createProduct() {
        return new Cpu();
    }
}
