package com.codegym.demo.service;

import com.codegym.demo.model.Blog;
import com.codegym.demo.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BlogService {
    Page<Blog> findAll(Pageable pageable);
    void saveBlog(Blog blog);
    void deleteBlogById(int id);
    Blog findById(Integer id);
    Iterable<Blog> findAllByCategory(Category category);
}
