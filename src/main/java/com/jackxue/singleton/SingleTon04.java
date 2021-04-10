package com.jackxue.singleton;

/**
 * 饿汉模式，静态代码块，线程安全
 */
public class SingleTon04 {
    private static SingleTon04 instance = null;
    private SingleTon04(){}

    static {
        instance = new SingleTon04();
    }
    /**
     * 加同步代码块实现
     * @return
     */
    private static SingleTon04 getInstance(){
        return instance;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                System.out.println(SingleTon04.getInstance().hashCode());
            }).start();
        }
    }
}
