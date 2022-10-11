package com.reflection;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

//利用反射创建file，并调用createNewFile（）进行创建
public class work2 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        String path = "java.io.File";
        Class info = Class.forName(path);
        Constructor[] con = info.getDeclaredConstructors();
        for (Constructor i : con) {
            System.out.println(i);
        }

        File file = (File) info.getDeclaredConstructor(String.class).newInstance("E:\\hh.txt");
        Method method = info.getDeclaredMethod("createNewFile");
        method.setAccessible(true);

        Object invoke = method.invoke(file);

    }
}
