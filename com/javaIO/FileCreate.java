package com.javaIO;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

public class FileCreate {
    public static void main(String[] args) {


    }

    @Test
    //父类的文件路径+子路径
    public void create01() {
        String filepath = "E:\\";
        String filename = "news.txt";
        File file = new File(filepath, filename);

        try {
            file.createNewFile();
            System.out.println("sure");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    //父目录文件+子路径
    public void creato2() {
        File filepath = new File("E:\\");
        String filename = "news1.txt";
        File file = new File(filepath, filename);
        try {
            file.createNewFile();
            System.out.println("sure");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    //根据路径创建文件
    public void createfile03() {
        String filepath = "E:\\news2.txt";
        File file = new File(filepath);
        try {
            file.createNewFile();
            System.out.println("sure");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

