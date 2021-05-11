package com.codegym.demo.service;

import com.codegym.demo.model.Customer;
import com.codegym.demo.model.Province;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;

public interface ICustomerService extends IGeneralService<Customer> {
    Page<Customer> findAll(Pageable pageable);
    Page<Customer> findByLastNameContaining(String name, Pageable pageable);
    List<Customer> findAllByProvince(Province province);
}
