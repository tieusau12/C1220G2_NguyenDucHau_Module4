package com.codegym.demo.service;

import com.codegym.demo.model.Blog;
import com.codegym.demo.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();
    Category findById(int id);
    void saveCategory(Category category);
    void deleteCategoryById(int id);
    Page<Category> findAll(Pageable pageable);
}
