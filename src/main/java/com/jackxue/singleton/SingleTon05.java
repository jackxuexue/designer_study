package com.jackxue.singleton;

/**
 * 懒汉模式，静态内部类实现，线程安全，推荐使用
 */
public class SingleTon05 {
    private SingleTon05(){}
    private static class holder{
        private static SingleTon05 instance = new SingleTon05();
    }
    public static SingleTon05 getInstance(){
        return holder.instance;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(SingleTon05.getInstance().hashCode());
        }
    }
}
