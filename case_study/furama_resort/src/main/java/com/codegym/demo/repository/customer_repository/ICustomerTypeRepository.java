package com.codegym.demo.repository.customer_repository;

import com.codegym.demo.model.customer.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerTypeRepository  extends JpaRepository<CustomerType, Integer> {
}
