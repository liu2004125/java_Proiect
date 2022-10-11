package com.javaIO.Stream.File;

import org.junit.jupiter.api.Test;

import java.io.FileOutputStream;
import java.io.IOException;

public class Fileoutputstream {
    public static void main(String[] args) {

    }

    @Test
    public void output1() {
        FileOutputStream out = null;
        try {
            out = new FileOutputStream("E:\\hello.txt", true);//append为true是追加填写，默认是覆写
            String str = "我是";
            out.write(str.getBytes());//转化为byte[]，读入
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
