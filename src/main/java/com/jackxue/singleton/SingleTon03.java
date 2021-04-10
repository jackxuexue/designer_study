package com.jackxue.singleton;

/**
 * 懒汉模式，线程安全，加锁
 */
public class SingleTon03 {
    private static SingleTon03 instance = null;
    private SingleTon03(){}

    /**
     * 加同步代码块实现
     * @return
     */
    private static synchronized SingleTon03 getInstance(){
        if(instance == null){
            instance = new SingleTon03();
        }
        return instance;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                System.out.println(SingleTon03.getInstance().hashCode());
            }).start();
        }
    }
}
