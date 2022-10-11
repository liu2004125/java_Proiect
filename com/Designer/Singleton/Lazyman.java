package com.Designer.Singleton;

public class Lazyman {

    //不会造成内存浪费，在需要时再new对象
    //volatile 保证多线程时不会出现指令重排序
    private volatile static Lazyman Instance;

    //单线程
    public static Lazyman getInstance() {
        if (null == Instance) {
            Instance = new Lazyman();
        }
        return Instance;
    }

    //多线程(DCL)双重检索
    //再多线程情况下保证安全又提高性能
    public static Lazyman getInstance2() {
        if (null == Instance) {
            synchronized (Lazyman.class) {
                if (null == Instance) {
                    Instance = new Lazyman();
                }
            }
        }
        return Instance;
    }

}
