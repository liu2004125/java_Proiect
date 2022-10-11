package com.javaway.Date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class data {
    public static void main(String[] args) throws ParseException {
        Date date = new Date();
        //转换的关键
        SimpleDateFormat str = new SimpleDateFormat("hh:mm:ss");
        String s = "10:10:11";
        date = str.parse(s);


        SimpleDateFormat now = new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss");
        String a;
        a = now.format(date);
        System.out.println(a);
    }
}
