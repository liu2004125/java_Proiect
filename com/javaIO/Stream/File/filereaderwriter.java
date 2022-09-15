package com.javaIO.Stream.File;

import org.junit.jupiter.api.Test;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class filereaderwriter {
    public static void main(String[] args) {

    }
    @Test
    public void reader(){
        FileReader read = null;
        char[] cha = new char[1024];
        int readline;
        try {
            read = new FileReader("E:\\hello.txt");
            while((readline=read.read(cha))!=-1){
                System.out.print(new String(cha,0,readline));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                read.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    @Test
    public void writer(){
        FileWriter writer = null;
        //writer char[],
        //writer string；
        //writer char[],0,写入指定的数组内容
        //writer string ,0,length,字符串指定内容
        try {
            writer = new FileWriter("E:\\hello.txt",true);
            writer.write("你好，我是伟皓  ");
            writer.write('h');
            writer.write("hello".toCharArray());



        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally{
            try {
                writer.close();//一定要关闭或者flush，否则不会写入到内存
                               //循环读入时，每读满一次缓存，需要flush一下，保证写入到硬盘
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    @Test
    public void copy(){
        FileWriter writer = null;
        FileReader read = null;
        char[] cah = new char[1024];
        int readline;
        try {
            writer = new FileWriter("E:\\you.txt");
            read = new FileReader("E:\\hello.txt");
            while ((readline = read.read(cah))!=-1){
                writer.write(cah,0,readline);
                writer.flush();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally{
            try {
                writer.close();
                read.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
