package com.javaway.Collection_;


import java.util.ArrayList;
import java.util.List;

public class listSort {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(new Book("西游记", 10));
        list.add(new Book("西游", 100));
        list.add(new Book("记", 1));

        sort(list);

        for (Object o : list) {
            System.out.println(o);
        }
    }

    public static void sort(List list) {
        int size = list.size();
        for (int i = 0; i < size - 1; i++) {
            for (int s = 0; s < size - 1 - i; s++) {
                Book book1 = (Book) list.get(s);
                Book book2 = (Book) list.get(s + 1);
                //区集合元素中的数据，再将元素的位置互换
                if (book1.getPrice() > book2.getPrice()) {
                    list.set(s, book2);
                    list.set(s + 1, book1);
                }
            }
        }
    }


}

class Book {
    private String name;
    private double price;

    public Book(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + price;
    }
}