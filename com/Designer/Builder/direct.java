package com.Designer.Builder;

public class direct {
    public Product build(builder build) {
        build.builda();
        build.buildc();
        build.buildb();
        return build.getProduct();
    }
}
