package com.codegym.handler_exception.controller;

import com.codegym.handler_exception.model.Customer;
import com.codegym.handler_exception.model.Province;
import com.codegym.handler_exception.service.ICustomerService;
import com.codegym.handler_exception.service.IProvinceService;
import com.codegym.handler_exception.service.exception.DuplicateEmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;


@Controller
@RequestMapping("customers")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private IProvinceService provinceService;

    @ModelAttribute("provinces")
    public Iterable<Province> allProvinces() {
        return provinceService.findAll();
    }

    @GetMapping
    public ModelAndView showList(Optional<String> s, Pageable pageInfo) throws Exception {
        ModelAndView modelAndView = new ModelAndView("/list");
        Page<Customer> customers = s.isPresent() ? search(s, pageInfo) : getPage(pageInfo);
        modelAndView.addObject("keyword", s.orElse(null));
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }

    @GetMapping("/{id}")
    public ModelAndView showInformation(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("/info");
        Optional<Customer> customerOptional = customerService.findOne(id);
        modelAndView.addObject("customer", customerOptional.get());
        return modelAndView;
    }

    // su dung try catch
//    @PostMapping
//    public ModelAndView updateCustomer(Customer customer) {
//        try {
//            customerService.save(customer);
//            return new ModelAndView("redirect:/customers");
//        } catch (DuplicateEmailException e) {
//            return new ModelAndView("/inputs_not_acceptable");
//        }
//    }
    @PostMapping
    public ModelAndView updateCustomer(Customer customer) throws DuplicateEmailException {
        customerService.save(customer);
        return new ModelAndView("redirect:/customers");
    }

    @ExceptionHandler(DuplicateEmailException.class)
    public ModelAndView showInputNotAcceptable() {
        return new ModelAndView("/inputs_not_acceptable");
    }


    private Page<Customer> getPage(Pageable pageInfo) {
        return customerService.findAll(pageInfo);
    }

    private Page<Customer> search(Optional<String> s, Pageable pageInfo) {
        return customerService.search(s.get(), pageInfo);
    }
}
