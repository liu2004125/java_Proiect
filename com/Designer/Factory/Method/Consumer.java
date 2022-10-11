package com.Designer.Factory.Method;

public class Consumer {
    public static void main(String[] args) {
        //工厂方法模式
        //通过直接new工厂来增加指定的对象
        //对比简单工厂，不再需要修改原来的工厂但会造成  ！类膨胀！
        Car tes = new TeslaFactory().getCar();
        Car wuling = new WulingFactory().getCar();
        Car bike = new bikeFactory().getCar();

        wuling.name();
        tes.name();
        bike.name();
    }
}
