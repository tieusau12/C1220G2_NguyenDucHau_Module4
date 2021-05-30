package com.codegym.demo.service.impl;

import com.codegym.demo.model.Category;
import com.codegym.demo.repository.ICategoryRepository;
import com.codegym.demo.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public void save(Category category) {
    categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(Integer id) {
    categoryRepository.deleteById(id);
    }
}
