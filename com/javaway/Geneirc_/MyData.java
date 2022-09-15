package com.javaway.Geneirc_;

public class MyData {
    private int month;
    private int day;
    private int year;

    MyData(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    @Override
    public String toString() {
        return "year  " + year + " month  " + month + " day  " + day;
    }

    static class Employee {
        private String name;
        private double salary;
        private MyData birthday;

        Employee(String name, double salary, MyData birthday) {
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

