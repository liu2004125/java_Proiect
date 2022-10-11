package com.javaIO.Stream.Buffer;

import org.junit.jupiter.api.Test;

import java.io.*;

public class BufferedStream {
    public static void main(String[] args) {

    }

    @Test
    public void input() throws IOException {
        BufferedInputStream in = new BufferedInputStream(new FileInputStream("E:\\hello.txt"));
        int readline = 0;
        while ((readline = in.read()) != -1) {
            System.out.print((char) readline);//因为是字节流，所以乱码
        }
        in.close();
    }

    @Test
    public void output() throws IOException {
        BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("E:\\hello.txt"));
        String i = "你你你";
        out.write(i.getBytes());
        out.write('q');
        out.close();
    }

    @Test
    public void copy() throws IOException {

    }
}
