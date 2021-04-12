package com.jackxue.observer;

import java.util.ArrayList;
import java.util.List;

public class ObserverTest {
    public static void main(String[] args) {
        Button b1 = new Button("button1");
        b1.addObserver(new ButtonObserver());
        b1.addObserver(new ButtonObserver1());
        b1.addObserver((event)->{
            System.out.println("o3 "+ event.getType());
        });
        b1.click();
        b1.release();
    }
}

class KeyEvent{
    private Button source;
    private String type;
    public KeyEvent(String type, Button source){
        this.source = source;
        this.type = type;
    }

    public Button getSource() {
        return source;
    }

    public void setSource(Button source) {
        this.source = source;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

class Button{
    String name;
    List<Observer> observers = new ArrayList<>();

    public Button(String name) {
        this.name = name;
    }

    public void addObserver(Observer observer){
        observers.add(observer);
    }

    public void click(){
        for (Observer observer : observers) {
            observer.eventFired(new KeyEvent("pressed", this));
        }
    }
    public void release(){
        for (Observer observer : observers) {
            observer.eventFired(new KeyEvent("released", this));
        }
    }
}

interface  Observer{
    void eventFired(KeyEvent event);
}


class ButtonObserver implements Observer{
    @Override
    public void eventFired(KeyEvent event) {
        System.out.println("o1 source:" + event.getSource().name + " type:"+ event.getType());
    }
}
class ButtonObserver1 implements Observer{
    @Override
    public void eventFired(KeyEvent event) {
        System.out.println("o2 source:" + event.getSource().name + " type:"+ event.getType());
    }
}






