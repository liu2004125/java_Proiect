package com.javaway.InnerClass_;


//定义Employee类，包含name salary birthday ，其中birthday是MyData类型
//要求放在集合list中，并重写tostring（）方法输出，利用内部类

import java.util.ArrayList;

public class Inner {
    public static void main(String[] args) {
        MyData_ myData = new MyData_(1990, 12, 1);
        MyData_ myData1 = new MyData_(1999, 11, 1);
        MyData_ myData2 = new MyData_(1790, 1, 1);
//      其他外部类引用内部类
//       先new外部类，再new内部类

        ArrayList list = new ArrayList();
        list.add(new MyData_.Employee("hao", 1000, myData));
        list.add(new MyData_.Employee("yao", 200, myData1));
        list.add(new MyData_.Employee("liu", 20, myData2));

        System.out.println(list);
    }
}

class MyData_ {
    private int month;
    private int day;
    private int year;

    MyData_(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    @Override
    public String toString() {
        return "year  " + year + " month  " + month + " day  " + day;
    }

    static class Employee {
        private String name;
        private double salary;
        private MyData_ birthday;

        Employee(String name, double salary, MyData_ birthday) {
            this.birthday = birthday;
            this.name = name;
            this.salary = salary;
        }

        @Override
        public String toString() {
            return "\n{ name  " + name
                    + " salary  " + salary
                    + " birthday  " + birthday;
        }
    }
}
