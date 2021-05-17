package com.codegym.demo.service;

import com.codegym.demo.model.Blog;
import com.codegym.demo.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    Blog findByName(String name);
    Page<Blog> findAllBlog(Pageable pageable);
    void saveBlog(Blog blog);
    Blog findById(Integer id);
    void removeBlog(Integer id);
    List<Blog> findAllByCategory(Category category);
}
