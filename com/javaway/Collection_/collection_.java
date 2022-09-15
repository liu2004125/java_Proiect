package com.javaway.Collection_;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;


public class collection_ {
    public static void main(String[] args) {

        ArrayList ary = new ArrayList();
        ary.add("bai");
        ary.add(2);
        ary.add(3);

        //for增强
        for (Object Dog : ary) {
            System.out.println(Dog);
        }
        Queue<int[][]> s = new LinkedList<>();

        //迭代器
        Iterator iterator = ary.iterator();
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            System.out.println(obj);
        }
    }
}

class Dog {
    private String name;
    private int age;

    public Dog(String name, int age) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return name + age;
    }
}