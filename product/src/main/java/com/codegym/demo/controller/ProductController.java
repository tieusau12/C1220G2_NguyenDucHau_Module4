package com.codegym.demo.controller;

import com.codegym.demo.model.Category;
import com.codegym.demo.model.Product;
import com.codegym.demo.service.ICategoryService;
import com.codegym.demo.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller

public class ProductController {
    @Autowired
    private IProductService<Product> productService;

    @Autowired
    private ICategoryService categoryService;

    @ModelAttribute("categories")
    public List<Category> categoryList() {
        return categoryService.findAll();
    }

    @RequestMapping("/")
    public String viewHome(Model model) {
        String name = null;
        String brand = null;
        String categoryName = null;
        return viewHomepage(model, 1, "name", "asc", name, brand, categoryName);
    }

    @GetMapping("/page/{pageNum}")
    private String viewHomepage(Model model,
                                @PathVariable(name = "pageNum") int currentPage,
                                @Param("sortField") String sortField,
                                @Param("sortDir") String sortDir,
                                @RequestParam(value = "name", required = false) String name,
                                @RequestParam(value = "brand", required = false) String brand,
                                @RequestParam(value = "categoryName", required = false) String categoryName
    ) {
        Page<Product> page = productService.findThreeField(currentPage, sortField, sortDir, name, brand, categoryName);
        List<Product> products = page.getContent();
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("productList", products);
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
        model.addAttribute("name", name);
        model.addAttribute("brand", brand);
        model.addAttribute("categoryName", categoryName);
        return "/index";
    }

    @GetMapping("/product-create")
    public String showCreateProduct(Model model) {
        model.addAttribute("product", new Product());
        return "/product/createProduct";
    }

    @PostMapping("/product-create")
    public String saveProduct(@Validated @ModelAttribute Product product, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "/product/createProduct";
        }
        productService.save(product);
        return "redirect:/";
    }

    @GetMapping("/product-edit/{id}")
    public String showEditCustomer(Model model, @PathVariable Long id) {
        model.addAttribute("products", productService.findById(id));
        return "/product/editProduct";
    }

    @PostMapping("/product-edit")
    public String editCustomer(@Validated @ModelAttribute Product product, BindingResult bindingResult, Model model) {
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("products", product);
            return "/product/editProduct";
        }
        productService.save(product);
        return "redirect:/";
    }

    @GetMapping("/product-view/{id}")
    public String showViewCustomer(Model model, @PathVariable(name = "id") Long id) {
        model.addAttribute("products", productService.findById(id));
        return "/product/viewProduct";
    }

    @GetMapping("/product-top5")
    public String showTop5ProductPrice(Model model) {
        model.addAttribute("products", productService.findTop5());
        return "/product/top5Price";
    }

    @GetMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable(name = "id") Long id) {
        productService.deleteById(id);
        return "redirect:/";
    }




}
