package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.IProductService;
import com.codegym.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ProductController {
    private final IProductService productService = new ProductService();

    @GetMapping
    public String index(Model model){
        List<Product>productList = productService.findAll();;
        model.addAttribute("products", productList);
        return "/index";
    }
}
