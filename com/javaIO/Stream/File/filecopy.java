package com.javaIO.Stream.File;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class filecopy {
    public static void main(String[] args) {

    }

    @Test
    public void copy() {
        FileInputStream in = null;
        FileOutputStream out = null;

        try {
            in = new FileInputStream("C:\\Users\\jiayao\\Desktop\\微信图片_20210810194542.jpg");
            out = new FileOutputStream("E:\\he.jpg");
            byte[] temp = new byte[1024];//设置缓存流
            int readlin = 0;
            while ((readlin = in.read(temp)) != -1) {
                out.write(temp, 0, readlin);//防止最后一次读取，读到不存在数据
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                in.close();
                out.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
