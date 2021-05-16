package com.codegym.demo.service;

import com.codegym.demo.model.OrderProduct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IOrderProductService {
    void createOrder(OrderProduct orderProduct);

    Page<OrderProduct> findAll(Pageable pageable);

    void deleteOrder(OrderProduct orderProduct);
}
