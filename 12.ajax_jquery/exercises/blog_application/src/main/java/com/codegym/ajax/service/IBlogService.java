package com.codegym.ajax.service;

import com.codegym.ajax.model.Blog;
import com.codegym.ajax.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    Blog findByName(String name);

    Page<Blog> findAllBlog(Pageable pageable);

    void saveBlog(Blog blog);

    Blog findById(Integer id);

    void removeBlog(Integer id);

    Blog findAllByCategory(Category category);

    List<Blog> findAllByName(String name);

//    Iterable<Blog> findAllByCategory(Category category);
}
