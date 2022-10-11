package com.project;

interface MethodInterface {

    //这个方法假如就是你想要传递的方法
    String test(String s);
}

public class main {
    public static void main(String[] args) {
        //MethodInterface me = new Method();

    }

    public static void test(MethodInterface methodInterface) {
        System.out.println(methodInterface.test("test"));
    }

}

class Method implements MethodInterface {
    @Override
    public String test(String s) {
        return s;
    }
}

class Method1 implements MethodInterface {
    @Override
    public String test(String s) {
        return s + s;
    }
}
