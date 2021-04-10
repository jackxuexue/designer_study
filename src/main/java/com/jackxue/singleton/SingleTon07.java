package com.jackxue.singleton;

/**
 * 使用枚举实现，懒汉模式，防止反射实例化的问题，由于枚举类没有构造函数。
 */
public enum SingleTon07 {
    INSTANCE;

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                System.out.println(SingleTon07.INSTANCE.hashCode());
            }).start();
        }
    }

}
