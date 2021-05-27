package com.codegym.demo.repository.customer_repository;

import com.codegym.demo.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository  extends JpaRepository<Customer, String> {
    @Query("select c from Customer c where concat(c.customerName,c.customerPhone,c.customerEmail) like %?1%")
    Page<Customer> searchByInputText(String keyword, Pageable pageable);
    Customer findByCustomerEmail(String email);
}
