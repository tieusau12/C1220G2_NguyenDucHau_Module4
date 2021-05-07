package com.codegym.demo.service;

import com.codegym.demo.model.Blog;

import java.util.List;

public interface BlogService {
    List<Blog> findAll();
    Blog findById(int id);
    void saveBlog(Blog blog);
    void deleteBlogById(int id);
}
