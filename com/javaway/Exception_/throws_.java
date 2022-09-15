package com.javaway.Exception_;

//运行试试
public class throws_ {
    public static void main(String[] args) {
        try {
            test();
        } catch (ArrayIndexOutOfBoundsException e) {
            // int[] b =new int[3];//处理异常
            // System.out.println(b[2]);
            throw new RuntimeException(); //throw,在语句中抛出异常
        } finally {
            System.out.println("抛出异常");
        }

    }

    //throws语句抛出异常给其调用者。
    public static void test() throws ArrayIndexOutOfBoundsException {
        int[] a = new int[2];
        System.out.println(a[3]);
    }
}
