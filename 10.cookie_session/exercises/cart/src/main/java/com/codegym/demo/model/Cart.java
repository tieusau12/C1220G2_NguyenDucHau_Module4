package com.codegym.demo.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cart {
//    private List<OrderProductDetail> orderProductDetails = new ArrayList<>();
    private Map<Product, Integer> orderProductDetails;

    public Cart() {
        this.orderProductDetails = new HashMap<>();
    }


    public Map<Product, Integer> getCart() {
        return orderProductDetails;
    }

    public void setCart(Map<Product, Integer> cart) {
        this.orderProductDetails = cart;
    }

    public void addToCart(Product product){
        if(orderProductDetails.containsKey(product)){
            orderProductDetails.replace(product,orderProductDetails.get(product),orderProductDetails.get(product)+1);
        }else {
            orderProductDetails.put(product,1);
        }
    }

    public void changeQuantity(Product product,Integer quantity){
        orderProductDetails.replace(product,orderProductDetails.get(product),quantity);
    }

    public void removeProduct(Product product){
        orderProductDetails.remove(product);
    }
    public Integer getQuantity(Product product){
        return orderProductDetails.get(product);
    }

    public double getTotalCost(){
        double totalMoney=0;
        for (Map.Entry<Product, Integer> entry : orderProductDetails.entrySet()) {
            totalMoney += entry.getKey().getPriceProduct()*entry.getValue();
        }
        return totalMoney;
    }
}
