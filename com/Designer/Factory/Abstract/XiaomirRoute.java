package com.Designer.Factory.Abstract;

public class XiaomirRoute implements IRouteProduct {
    @Override
    public void start() {
        System.out.println("xiaomikaiji");
    }

    @Override
    public void end() {
        System.out.println("xiaomiguanji");
    }
}
