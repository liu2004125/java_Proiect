package com.Designer.Factory.Abstract;

public class Client {
    public static void main(String[] args) {
        //具体的厂商通过实现IProduct接口，来确认生产的产品类型（phone/route）
        //具体的产品要实现它的工厂，以工厂为中介链接厂商和产品
        //该产品类型再通过厂商接口确定具体的产品（小米/huawei）
        Xiaonmi xiaonmi = new Xiaonmi();
        IphoneProduct xmphone = xiaonmi.getphone();
        xmphone.start();
        xmphone.end();

        IRouteProduct xmroute = xiaonmi.getroute();
        xmroute.start();
        xmroute.end();

        huawei huawei = new huawei();
        IphoneProduct hwphone = huawei.getphone();
        hwphone.start();
        hwphone.end();
        IRouteProduct hwroute = huawei.getroute();
        hwroute.start();
        hwroute.end();

    }
}
