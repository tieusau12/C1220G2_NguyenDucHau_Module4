package com.codegym.demo.service;


import com.codegym.demo.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService<E> {
   Page<Product> findThreeField(int pageNum, String sortField, String sortDir, String name, String brand, String categoryName );
    void save(E e);
    E findById(Long id);
    void deleteById(Long id);
    List<Product> findTop5();
}
