package com.example.designmode.singleton;

public class Singleton {
    private Singleton(){}
    //多线程同步，每次都需要进行同步
    public static Singleton getInstance(){

        return SingletonHolder.instance;
    }

    /**
     * 静态内部类
     */
    private static class SingletonHolder{
        private static final Singleton instance = new Singleton();
    }
}
