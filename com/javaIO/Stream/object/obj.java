package com.javaIO.Stream.object;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.sql.SQLOutput;

public class obj {
    public static void main(String[] args) {

    }
    @Test
    public void output()throws IOException{
        ObjectOutputStream out =new ObjectOutputStream(new FileOutputStream("E:\\ha.dat"));
        out.writeObject(new cat("小花",10));
        out.writeObject(new cat("小苗",2));
        out.close();
    }
    @Test
    public void input() throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("E:\\ha.dat"));
        while(true) {//循环读取必须保证类型一致
            try {
                System.out.println(in.readObject());
            } catch (EOFException e) {
                System.out.println("out");
                break;
            }
        }
            in.close();
    }
}
class cat implements Serializable{
    String name;
    int age;
    public cat(String name,int age){
        this.age=age;
        this.name=name;
    }

    @Override
    public String toString() {
        return "cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
