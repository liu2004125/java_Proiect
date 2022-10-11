package com.Designer.Singleton;

public class SingleObject {
    //构造器私有化
    private static SingleObject Instance = new SingleObject();

    private SingleObject() {
    }

    ;

    //获取唯一可用实例
    public static SingleObject getInstance() {
        return Instance;
    }

    public void Message() {
        System.out.println("hello");
    }
}
