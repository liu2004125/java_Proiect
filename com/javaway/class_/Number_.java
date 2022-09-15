package com.javaway.class_;


public class Number_ {

    public static void main(String[] args) {
        Integer i = 100;
        String s = "200";
        //  s= i.toString();
        i = i.valueOf(s);
        Boolean t = i.equals(s);
        System.out.println(Integer.parseInt(s));
    }

}

