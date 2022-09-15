package com.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class create {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException,
            InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        //获取类的对象的方法
        // 1 已有类
        Class<test> testClass = test.class;
        //2 拥有实例对象
        test t = new test();
        Class clazz = t.getClass();

        String path = "com.reflection.cat";
        //在编译阶段未知，在运行阶段可以确认
        Class info  = Class.forName(path);
        Field[] fields = info.getFields();

        //输出该反射是谁的
        System.out.println(info);
        //该类的运行类型
        System.out.println(info.getClass());
        //该类的包名
        System.out.println(info.getPackage().getName());
        //通过反射创建一个类的对象,指定一个构造方法(运行时)，默认无参()
        Constructor[] cons = info.getDeclaredConstructors();//得到所有的构造器
        for (Constructor con : cons) {
            System.out.println(con);
        }
        cat cat1 = (cat)info.getConstructor(String.class,int.class,String.class).newInstance("a",10,"male");
        System.out.println(cat1);
        //通过反射得到属性(非私有)
        Field sex = info.getField("sex");//该反射class类对应的类的属性名
        Field name = info.getField("name");
        System.out.println(sex.get(cat1));//
        System.out.println(name.get(cat1));
        //通过反射设置属性(指定对象)
        sex.set(cat1,"female");
        System.out.println(sex.get(cat1));
    }
}
class test{

}
