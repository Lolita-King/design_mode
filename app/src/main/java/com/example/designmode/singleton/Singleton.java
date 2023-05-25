package com.example.designmode.singleton;

public class Singleton {
    private static Singleton instance;
    private Singleton(){}
    //多线程同步，每次都需要进行同步
    public static synchronized Singleton getInstance(){
        if (instance == null){
            instance = new Singleton();
        }
        return instance;
    }
}
