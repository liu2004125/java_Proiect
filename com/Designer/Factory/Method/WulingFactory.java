package com.Designer.Factory.Method;


public class WulingFactory implements Factory {
    @Override
    public Car getCar() {
        return new Wuling();
    }
}
