package com.Designer.Factory.Simple;


public class CarFactory {
    //静态工厂模式
    //增加新功能，必须要修改源代码逻辑(违反开闭原则)
    public static Car getCar(String car) {
        if (car.equals("Wuling"))
            return new Wuling();
        else if (car.equals("Tesla"))
            return new Tesla();
        else if (car.equals("bike")) {
            return new bike();
        }
        return null;
    }
}
