package com.codegym.demo.controller;

import com.codegym.demo.model.Blog;
import com.codegym.demo.model.Category;
import com.codegym.demo.service.IBlogService;
import com.codegym.demo.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private IBlogService blogService;

    @GetMapping("/category")
    public ResponseEntity<List<Category>> showCategory() {
        return new ResponseEntity<>(categoryService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/blogOfCategories/{id}")
    public ResponseEntity<List<Blog>> showBlogOfCategories(@PathVariable Integer id, Model model){
        Category category = categoryService.findById(id);
        List<Blog> blogList = blogService.findAllByCategory(category);
        return new ResponseEntity<>(blogList,HttpStatus.OK);
    }
}
