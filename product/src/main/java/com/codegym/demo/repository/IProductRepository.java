package com.codegym.demo.repository;

import com.codegym.demo.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IProductRepository  extends JpaRepository<Product, Long> {
    Page<Product> getByNameContainingAndBrandContainingAndCategory_CategoryNameContaining(String name, String brand, String categoryName, Pageable pageable);
    List<Product> findTop5ByOrderByProductPriceDesc();

}
