package com.javaway.Compare;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class comparTo_ {
    public static void main(String[] args) {
        List<people> peo = new ArrayList<>();
        peo.add(new people(10, "nn"));
        peo.add(new people(12, "mm"));
        peo.add(new people(18, "yy"));

        peo.sort(new peopleComparetO());
        for (int i = 0; i < 3; i++) {
            System.out.println(peo.get(i));
        }
    }
}

class people {
    private int age;
    private String name;

    public people(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}

class peopleComparetO implements Comparator<people> {
    @Override
    public int compare(people o1, people o2) {
        return o1.getAge() - o2.getAge();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}