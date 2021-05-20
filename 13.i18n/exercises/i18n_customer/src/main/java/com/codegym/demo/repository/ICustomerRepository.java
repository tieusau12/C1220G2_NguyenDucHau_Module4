package com.codegym.demo.repository;


import com.codegym.demo.model.Customer;
import com.codegym.demo.model.Province;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Long> {
    Page<Customer> findAll(Pageable pageable);
    Page<Customer> findByLastNameContaining(String name, Pageable pageable);
    List<Customer> findAllByProvince(Province province);
}
