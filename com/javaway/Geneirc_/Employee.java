package com.javaway.Geneirc_;

class Employee<E> {
    private String name;
    private double salary;
    private E birthday;

    Employee(String name, double salary, E birthday) {
        this.birthday = birthday;
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public E getBirthday() {
        return birthday;
    }

    public void setBirthday(E birthday) {
        this.birthday = birthday;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "\n{ name  " + name
                + " salary  " + salary
                + " birthday  " + birthday;
    }
}
