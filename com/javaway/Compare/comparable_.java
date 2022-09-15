package com.javaway.Compare;

import java.util.Arrays;

public class comparable_ {
    public static void main(String[] args) {
        person[] people = new person[]{
                new person(10, "nn"),
                new person(12, "mm"),
                new person(18, "yy")
        };
        Arrays.sort(people);

    }
}

class person implements Comparable<person> {
    private int age;
    private String name;

    public person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int compareTo(person o) {
        return o.age - this.age;
    }
}
