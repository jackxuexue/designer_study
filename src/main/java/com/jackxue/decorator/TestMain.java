package com.jackxue.decorator;

public class TestMain {
    public static void main(String[] args) {
        Tank tank = new Tank();
        SurfaceDecorator surfaceDecorator = new SurfaceDecorator(tank);
        WheelDecorator wheelDecorator = new WheelDecorator(surfaceDecorator);
        wheelDecorator.draw();

    }
}

interface GameObject{
    void draw();
}

class Tank implements GameObject{

    @Override
    public void draw() {
        System.out.println("普通的坦克");
    }
}

abstract class Decorator implements GameObject{

    protected GameObject gameObject;

    Decorator(GameObject g){
        this.gameObject = g;
    }

    @Override
    public void draw() {
        gameObject.draw();
    }
}

class SurfaceDecorator extends Decorator{

    SurfaceDecorator(GameObject g) {
        super(g);
    }

    @Override
    public void draw() {
        System.out.print("装饰外表-");
        this.gameObject.draw();
    }
}

class WheelDecorator extends Decorator{
    WheelDecorator(GameObject g) {
        super(g);
    }

    @Override
    public void draw() {
        System.out.print("装饰轮子-");
        super.draw();
    }
}





