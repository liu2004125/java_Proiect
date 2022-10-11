package com.Designer.Factory.Abstract;

public class huawei implements IProductFactory {
    @Override
    public IphoneProduct getphone() {
        return new huaweiphone();
    }

    @Override
    public IRouteProduct getroute() {
        return new huaweiRoute();
    }
}
