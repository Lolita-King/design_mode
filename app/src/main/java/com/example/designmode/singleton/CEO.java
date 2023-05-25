package com.example.designmode.singleton;

/**
 * CEO
 * 饿汉单例模式
 */
public class CEO extends Staff{
    private static final CEO mCEO = new CEO();
    //构造器私有
    private CEO(){}

    //多外暴露获取单例对象的方法
    public static CEO getCEO(){
        return mCEO;
    }

    @Override
    public void doWork() {
        //管理VP
    }
}
