package com.codegym.demo.model;

import javax.persistence.*;

@Entity
@Table
public class OrderProductDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idOrderProductDetail;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderProduct orderProduct;

    public OrderProductDetail() {
    }

    public OrderProductDetail(Product product, OrderProduct orderProduct) {
        this.product = product;
        this.orderProduct = orderProduct;
    }

    public Integer getIdOrderProductDetail() {
        return idOrderProductDetail;
    }

    public void setIdOrderProductDetail(Integer idOrderProductDetail) {
        this.idOrderProductDetail = idOrderProductDetail;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public OrderProduct getOrderProduct() {
        return orderProduct;
    }

    public void setOrderProduct(OrderProduct orderProduct) {
        this.orderProduct = orderProduct;
    }
}
