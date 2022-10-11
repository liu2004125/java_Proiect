package com.javaIO.Stream.ZIP;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

//压缩文件
public class ZIPIN {
    public static void main(String[] args) {
        try {
            filetozip("E:\\hello.txt", "E:\\HA.zip");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void filetozip(String srcpath, String zipfile) throws IOException {
        //读取文件
        InputStream in = new FileInputStream(srcpath);
        ZipInputStream zipInputStream = new ZipInputStream(in);
        //创建输出流
        ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(zipfile));
        //ZipEntry是指在zip目录下的文件
        zipOutputStream.putNextEntry(new ZipEntry("image01.txt"));
        int temp = 0;
        while (zipInputStream.read() != -1) {
            //读入数据存在temp中，利用temp输出
            zipOutputStream.write(temp);
        }
        zipInputStream.close();
        zipOutputStream.close();

    }
}
