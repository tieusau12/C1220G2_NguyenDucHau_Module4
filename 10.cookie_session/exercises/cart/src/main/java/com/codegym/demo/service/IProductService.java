package com.codegym.demo.service;

import com.codegym.demo.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService {
    void createProduct(Product product);

    Product findById(Integer id);

    Page<Product> findAll(Pageable pageable);
}
