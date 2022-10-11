package com.Designer.Factory.Abstract;

public class XiaomiPhone implements IphoneProduct {
    @Override
    public void start() {
        System.out.println("xiaomiphone");
    }

    @Override
    public void end() {
        System.out.println("xiaomiendphone");
    }
}
