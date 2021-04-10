package com.jackxue.singleton;

import java.util.concurrent.TimeUnit;

/**
 * 懒汉模式，线程不安全的方式
 */
public class SingleTon02 {
    private static SingleTon02 instance = null;
    private SingleTon02(){}
    private static SingleTon02 getInstance(){
        if(instance == null){
            //测试多线程并发的问题
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            instance = new SingleTon02();
        }
        return instance;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                System.out.println(SingleTon02.getInstance().hashCode());
            }).start();
        }
    }
}
