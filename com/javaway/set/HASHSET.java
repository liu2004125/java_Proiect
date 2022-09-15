package com.javaway.set;

import java.util.HashSet;
import java.util.Objects;

//要求name和birthday相同时不可插入
public class HASHSET {
    public static void main(String[] args) {
        HashSet<Object> hash = new HashSet<>();
        hash.add(new employees("wei", 18, new mydata(1999, 1, 25)));
        hash.add(new employees("wei", 10, new mydata(2001, 2, 1)));
        hash.add(new employees("wei", 18, new mydata(1999, 1, 25)));
        System.out.println(hash);
    }

}

class employees {
    private String name;
    private int number;

    private mydata birthday;

    public employees(String name, int number, mydata birthday) {
        this.name = name;
        this.number = number;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        employees employees = (employees) o;
        return number == employees.number
                && Objects.equals(name, employees.name) && Objects.equals(birthday, employees.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, birthday);
    }

    @Override
    public String toString() {
        return "name" + name + "number" + number + "birthday" + birthday + "\n";
    }
}

class mydata {
    private int year;
    private int month;
    private int day;

    public mydata(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        mydata mydata = (mydata) o;
        return year == mydata.year && month == mydata.month && day == mydata.day;
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, month, day);
    }

}