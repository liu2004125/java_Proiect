package com.Designer.Factory.Method;


public class TeslaFactory implements Factory {
    @Override
    public Car getCar() {
        return new Tesla();
    }
}
