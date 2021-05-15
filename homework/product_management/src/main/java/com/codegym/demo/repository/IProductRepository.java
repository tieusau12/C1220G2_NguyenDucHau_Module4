package com.codegym.demo.repository;

import com.codegym.demo.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository  extends JpaRepository<Product,Integer> {
    Page<Product> findAll(Pageable pageable);
    Page<Product> findAllByCategory_Name(String name,Pageable pageable);
}
