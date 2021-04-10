package com.jackxue.singleton;

/**
 * 懒汉模式，锁，双判断, 线程安全
 */
public class SingleTon06 {
    private static volatile SingleTon06 instance = null;
    private SingleTon06(){}
    private static SingleTon06 getInstance(){
        //第一次判断，为了以后不用使用锁，提高性能
        if(instance == null){
            synchronized (SingleTon06.class){
                //第二次判断，防止多线程并发的问题
                if(instance == null){
                    instance = new SingleTon06();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                System.out.println(SingleTon06.getInstance().hashCode());
            }).start();
        }
    }
}
