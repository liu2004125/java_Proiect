package com.javaIO.Stream.Conversion;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class REader {
    public static void main(String[] args) {
        File f1 = new File("E:\\ha.dat");
        if(f1.exists()) f1.delete();

    }
    @Test
    public void read()throws IOException {
        //FileInputStream in = new FileInputStream("E:\\hello.txt");字节流处理字符出现乱码
        InputStreamReader in = new InputStreamReader(new FileInputStream("E:\\hello.txt"), "utf-8");
        //将in包装为buffered，提高读取效率
        BufferedReader bis= new BufferedReader(in);
        int readline ;
        while(in.ready()){
            System.out.print((char)in.read());
        }
        in.close();
    }
    @Test
    public void writer() throws IOException{
        //指定编码
        OutputStreamWriter out = new OutputStreamWriter(
                                        new FileOutputStream("E:\\you.txt",true),"GBK");
        //包装
        BufferedWriter bw = new BufferedWriter(out);
        out.write("你是sc");
        out.close();
    }
}
