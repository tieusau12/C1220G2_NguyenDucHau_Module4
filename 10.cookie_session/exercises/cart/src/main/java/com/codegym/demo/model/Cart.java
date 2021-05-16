package com.codegym.demo.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<OrderProductDetail> orderProductDetails = new ArrayList<>();

    public Cart() {
    }

    public void add(OrderProductDetail orderProductDetail) {
        this.orderProductDetails.add(orderProductDetail);
    }

    public List<OrderProductDetail> getOrderProductDetails() {
        return orderProductDetails;
    }

    public void setOrderProductDetails(List<OrderProductDetail> orderProductDetails) {
        this.orderProductDetails = orderProductDetails;
    }
}
