package com.codegym.demo.service;


import com.codegym.demo.model.Category;

import java.util.List;

public interface ICategoryService {

    List<Category> findAll();

    void save(Category category);

    void deleteCategory(Integer id);
}
