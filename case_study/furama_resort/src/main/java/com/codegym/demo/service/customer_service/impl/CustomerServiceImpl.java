package com.codegym.demo.service.customer_service.impl;

import com.codegym.demo.model.customer.Customer;
import com.codegym.demo.model.customer.CustomerType;
import com.codegym.demo.repository.customer_repository.ICustomerRepository;
import com.codegym.demo.repository.customer_repository.ICustomerTypeRepository;
import com.codegym.demo.service.customer_service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;
    @Autowired
    private ICustomerTypeRepository customerTypeRepository;

    @Override
    public void saveCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public Customer findById(String id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public List<CustomerType> findAllCustomerType() {
        return customerTypeRepository.findAll();
    }

    @Override
    public void deleteById(String id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Page<Customer> findAllCustomerByName(Pageable pageable, String name) {
        return customerRepository.searchByInputText(name, pageable);
    }

    @Override
    public String checkDuplicate(Customer customer) {
        if (customerRepository.findByCustomerEmail(customer.getCustomerEmail()) != null) {
            return "Email đã tồn tại";
        } else if (customerRepository.findById(customer.getCustomerId()).isPresent()) {
            return "Mã khách hàng đã tồn tại";
        }
        return null;
    }
}
