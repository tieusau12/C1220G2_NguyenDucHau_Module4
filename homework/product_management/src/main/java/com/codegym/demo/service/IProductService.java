package com.codegym.demo.service;

import com.codegym.demo.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService {
    Page<Product> findAll(Pageable pageable);
    void deleteProduct(Integer id);
    Product findById(Integer id);
    void saveProduct(Product product);
    Page<Product> findAllByCategoryName(String name ,Pageable pageable);
}
