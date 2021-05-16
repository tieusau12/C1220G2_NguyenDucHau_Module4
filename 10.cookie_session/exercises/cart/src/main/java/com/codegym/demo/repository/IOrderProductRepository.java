package com.codegym.demo.repository;

import com.codegym.demo.model.OrderProduct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderProductRepository extends JpaRepository<OrderProduct, Integer> {
    Page<OrderProduct> findAll(Pageable pageable);
}
