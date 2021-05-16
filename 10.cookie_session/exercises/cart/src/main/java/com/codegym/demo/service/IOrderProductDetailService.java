package com.codegym.demo.service;

import com.codegym.demo.model.OrderProductDetail;

import java.util.List;

public interface IOrderProductDetailService {
    List<OrderProductDetail> findAll();

    void create(OrderProductDetail orderProductDetail);

    OrderProductDetail update(String id);

    void deleteOrderProductDetail(Integer id);
}
