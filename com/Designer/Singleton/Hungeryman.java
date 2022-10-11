package com.Designer.Singleton;

public class Hungeryman {
    /*这种方式比较常用，但容易产生垃圾对象。
    优点：没有加锁，执行效率会提高。
    缺点：类加载时就初始化，浪费内存。
    */
    private static Hungeryman Instance = new Hungeryman();

    private Hungeryman() {
    }

    ;

    public static Hungeryman getInstance() {
        return Instance;
    }
}
