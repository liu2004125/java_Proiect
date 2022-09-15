package com.javaway.Geneirc_;

import java.util.ArrayList;

//定义Employee类，包含name salary birthday ，其中birthday是MyData类型
//要求放在集合list中，并重写tostring（）方法输出，利用泛型
//也可以使用内部类实现

public class Generic_ {
    public static void main(String[] args) {
        ArrayList<Employee> list = new ArrayList();
        list.add(new Employee<MyData>("hao", 1000, new MyData(1990, 10, 11)));
        list.add(new Employee<MyData>("yao", 200, new MyData(1999, 1, 15)));
        list.add(new Employee<MyData>("liu", 20, new MyData(2004, 1, 25)));

        System.out.println(list);

    }
}



