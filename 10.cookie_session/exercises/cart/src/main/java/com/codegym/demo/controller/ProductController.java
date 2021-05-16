package com.codegym.demo.controller;

import com.codegym.demo.model.Product;
import com.codegym.demo.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping("/")
    public String showHome(Model model, Pageable pageable){
        model.addAttribute("products",productService.findAll(pageable));
        return "home";
    }

    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("product",new Product());
        return "create";
    }

    @PostMapping("/create")
    public String createProduct(@ModelAttribute Product product){
        productService.createProduct(product);
        return "redirect:/";
    }

    @GetMapping("/{id}/buy")
    public String showProduct(@PathVariable Integer id, Model model){
        model.addAttribute("product",productService.findById(id));
        return "showProduct";
    }

}
