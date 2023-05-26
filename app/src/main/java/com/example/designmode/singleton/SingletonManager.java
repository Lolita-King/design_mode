package com.example.designmode.singleton;

import java.util.HashMap;
import java.util.Map;

public class SingletonManager {
    private static Map<String,Object> objectMap =new HashMap<>();
    private SingletonManager(){}
    public static void registerService(String key,Object instance){
        if (!objectMap.containsKey(key)){
            objectMap.put(key,instance);
        }
    }
    public static Object getService(String key){
        return objectMap.get(key);
    }
}
