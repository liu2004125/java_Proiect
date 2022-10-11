package com.Designer.Factory.Method;

public class bikeFactory implements Factory {
    @Override
    public Car getCar() {
        return new bike();
    }
}
