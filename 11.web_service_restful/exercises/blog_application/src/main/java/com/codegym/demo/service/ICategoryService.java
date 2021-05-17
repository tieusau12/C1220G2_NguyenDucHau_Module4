package com.codegym.demo.service;

import com.codegym.demo.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();
    Page<Category> findAllCategory(Pageable pageable);
    void saveCategory(Category category);
    Category findById(Integer id);
    void removeCategory(Integer id);
}
