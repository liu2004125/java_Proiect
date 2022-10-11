package com.Designer.Builder;

public class test {
    public static void main(String[] args) {
        //指挥，确定顺序
        direct direct = new direct();
        //工人，生产产品
        Product build = direct.build(new worker());

    }
}
