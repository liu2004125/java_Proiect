package com.javaIO.Stream.File;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class Fileinputstream {
    public static void main(String[] args) {

    }

    //依次读入一个字节转化为char输出
    @Test
    public void read1() {
        FileInputStream input = null;
        int read = 0;
        try {
            input = new FileInputStream("E:\\hello.txt");
            while ((read = input.read()) != -1) {
                System.out.print((char) read);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                input.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Test
    public void read2() {
        FileInputStream input = null;
        //利用缓冲流，一次读取8个
        byte[] buf = new byte[8];
        int data = 0;
        try {
            input = new FileInputStream("E:\\hello.txt");

            while ((data = input.read(buf)) != -1) {
                System.out.print(new String(buf, 0, data));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                input.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

