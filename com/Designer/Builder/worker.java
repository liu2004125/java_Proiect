package com.Designer.Builder;

public class worker extends builder {
    private Product product;

    public worker() {
        product = new Product();
    }

    @Override
    void builda() {
        product.setA("a");
        System.out.println("a");
    }

    @Override
    void buildb() {
        product.setB("b");
        System.out.println("b");
    }

    @Override
    void buildc() {
        product.setC("c");
        System.out.println("c");
    }

    @Override
    Product getProduct() {
        return product;
    }
}
