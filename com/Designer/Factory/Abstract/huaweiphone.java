package com.Designer.Factory.Abstract;

public class huaweiphone implements IphoneProduct {
    @Override
    public void start() {
        System.out.println("huaweiphone");
    }

    @Override
    public void end() {
        System.out.println("huaweiendphone");
    }
}
