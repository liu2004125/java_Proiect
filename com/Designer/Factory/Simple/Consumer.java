package com.Designer.Factory.Simple;

public class Consumer {
    public static void main(String[] args) {
        //原始版本
        //接口，所以的实现类
//        Car car1= new Tesla();
//        Car car2 = new Wuling();
//
//        car1.name();
//        car2.name();
        //简单工厂模式(静态工厂模式)
        Car car1 = CarFactory.getCar("Wuling");
        Car car2 = CarFactory.getCar("Tesla");
        car1.name();
        car2.name();
        Car bike = CarFactory.getCar("bike");
        bike.name();


    }
}
