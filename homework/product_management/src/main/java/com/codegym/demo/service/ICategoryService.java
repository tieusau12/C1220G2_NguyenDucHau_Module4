package com.codegym.demo.service;

import com.codegym.demo.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();

    void deleteById(Integer id);

    void save(Category category);

    Category findById(Integer id);
}
