package com.codegym.demo.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "order_product")
public class OrderProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idOrder;
    private Integer quantity;


    @OneToMany(mappedBy = "orderProduct")
    private Set<OrderProductDetail> orderProductDetails = new HashSet<>();

    public OrderProduct() {
    }

    public Integer getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Integer idOrder) {
        this.idOrder = idOrder;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Set<OrderProductDetail> getOrderProductDetails() {
        return orderProductDetails;
    }

    public void setOrderProductDetails(Set<OrderProductDetail> orderProductDetails) {
        this.orderProductDetails = orderProductDetails;
    }
}
