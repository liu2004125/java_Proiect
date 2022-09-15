package com.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class secarh {
    public static void main(String[] args) throws ClassNotFoundException{
        //加载并初始化指定的类reflect
        Class classInfo = Class.forName("com.reflection.cat");
        Constructor[] con = classInfo.getConstructors();//构造器
        Field[] fil = classInfo.getFields();//属性
        Method[] methods = classInfo.getMethods();
        for (int i = 0; i < con.length; i++) {
            System.out.println(con[i].toString());
            System.out.println(fil[i].toString());
            System.out.println(methods[i].toString());
        }

    }
}
class cat{
    public String name = "steve";
    public int age = 1;
    public String sex="male";

    public cat(String name, int age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }
    public cat() {}
    public void funtion(int i,String way){}
    public void growth(){}
}
