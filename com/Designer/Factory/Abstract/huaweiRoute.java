package com.Designer.Factory.Abstract;

public class huaweiRoute implements IRouteProduct {
    @Override
    public void start() {
        System.out.println("huaweikaiji");
    }

    @Override
    public void end() {
        System.out.println("huaweiguanji");
    }
}
