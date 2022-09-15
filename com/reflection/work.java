package com.reflection;


import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

//通过反射创建对象，并修改私有属性，并调用方法
public class work {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException,
            InvocationTargetException, InstantiationException {

        Class<privateTest> info=privateTest.class;
        Constructor<privateTest> con = info.getConstructor();

        privateTest t = con.newInstance();//实例对象
        Field f=info.getDeclaredField("name");
        f.setAccessible(true);
        f.set(t,"liu");//属性对象,t是实例对象

        Method med = info.getMethod("getName");
        Object invoke = med.invoke(t);//实例对象
        System.out.println(invoke);
        //System.out.println(t.getName());
    }

}
class privateTest{
    private String name = "weihao";
    public String getName() {
        return name;
    }
    public privateTest(){}
}
