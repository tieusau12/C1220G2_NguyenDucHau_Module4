package com.codegym.ajax.controller;

import com.codegym.ajax.model.Category;
import com.codegym.ajax.service.IBlogService;
import com.codegym.ajax.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private IBlogService blogService;

    @ModelAttribute("categories")
    public Iterable<Category> categories() {
        return categoryService.findAll();
    }

    @GetMapping("/create/category")
    public String showPage(Model model) {
        model.addAttribute("category", new Category());
        return "category/createCategory";
    }

    @PostMapping("/create/category")
    public String createCategory(Category category) {
        categoryService.saveCategory(category);
        return "redirect:/";
    }

    @GetMapping("/blogOfCategories/{id}")
    public String showBlogOfCategories(@PathVariable Integer id, Model model) {
        Category category = categoryService.findById(id);
        model.addAttribute("category", category);
        model.addAttribute("blogs", blogService.findAllByCategory(category));
        return "category/view";
    }
}
