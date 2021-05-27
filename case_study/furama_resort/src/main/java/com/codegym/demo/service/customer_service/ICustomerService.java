package com.codegym.demo.service.customer_service;

import com.codegym.demo.model.customer.Customer;
import com.codegym.demo.model.customer.CustomerType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {
    void saveCustomer(Customer customer);

    Page<Customer> findAll(Pageable pageable);

    Customer findById(String id);

    List<CustomerType> findAllCustomerType();

    void deleteById(String id);

    Page<Customer> findAllCustomerByName(Pageable pageable, String name);

    String checkDuplicate(Customer customer);
}
