package com.jackxue.singleton;

/**
 * 懒汉模式
 * 线程安全，推荐使用这种方式
 */
public class SingleTon01 {
    private static SingleTon01 instance = new SingleTon01();
    private SingleTon01(){
    }

    public static SingleTon01 getInstance(){
        return instance;
    }

    public static void main(String[] args) {
        //开启多线程去测试
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                System.out.println(SingleTon01.getInstance().hashCode());
            }).start();
        }
    }
}
