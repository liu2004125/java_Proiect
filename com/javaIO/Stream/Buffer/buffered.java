package com.javaIO.Stream.Buffer;

import org.junit.jupiter.api.Test;

import java.io.*;

public class buffered {
    public static void main(String[] args) {

    }

    @Test
    public void reader() throws IOException {
        BufferedReader read = new BufferedReader(new FileReader("E:\\hello.txt"));
        String line;
        while ((line = read.readLine()) != null) {
            System.out.println(line);
        }
        read.close();
    }

    @Test
    public void writer() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("E:\\hello.txt", true));
        writer.newLine();
        writer.write("你好你好");
        writer.write("我是sb".toCharArray());
        writer.close();
    }

    @Test
    public void copy() throws IOException {

    }
}
