package com.example.designmode.singleton;

public class Singleton {
    private static Singleton instance;
    private Singleton(){}
    //多线程同步，每次都需要进行同步
    public static Singleton getInstance(){
        //避免不必要的同步
        if (instance == null){
            synchronized (Singleton.class){
                //防止多线程冲突
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
