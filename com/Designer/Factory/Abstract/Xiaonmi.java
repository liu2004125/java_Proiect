package com.Designer.Factory.Abstract;

public class Xiaonmi implements IProductFactory {
    @Override
    public IphoneProduct getphone() {
        return new XiaomiPhone();
    }

    @Override
    public IRouteProduct getroute() {
        return new XiaomirRoute();
    }
}
