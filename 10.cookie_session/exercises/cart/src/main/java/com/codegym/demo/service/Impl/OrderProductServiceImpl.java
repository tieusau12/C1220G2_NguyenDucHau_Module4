package com.codegym.demo.service.Impl;

import com.codegym.demo.model.OrderProduct;
import com.codegym.demo.repository.IOrderProductRepository;
import com.codegym.demo.service.IOrderProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class OrderProductServiceImpl implements IOrderProductService {

    @Autowired
    private IOrderProductRepository orderProductRepository;

    @Override
    public void createOrder(OrderProduct orderProduct) {
        orderProductRepository.save(orderProduct);
    }

    @Override
    public Page<OrderProduct> findAll(Pageable pageable) {
        return orderProductRepository.findAll(pageable);
    }

    @Override
    public void deleteOrder(OrderProduct orderProduct) {
        orderProductRepository.delete(orderProduct);
    }
}
