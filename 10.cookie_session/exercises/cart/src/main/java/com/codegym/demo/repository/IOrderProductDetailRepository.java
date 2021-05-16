package com.codegym.demo.repository;

import com.codegym.demo.model.OrderProductDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderProductDetailRepository extends JpaRepository<OrderProductDetail, Integer> {
}
