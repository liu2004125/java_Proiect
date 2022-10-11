package com.Designer.Singleton;

public class SingleDemo {
    public static void main(String[] args) {
        //通过获取唯一实例
        SingleObject object = SingleObject.getInstance();

        object.Message();

    }
}
