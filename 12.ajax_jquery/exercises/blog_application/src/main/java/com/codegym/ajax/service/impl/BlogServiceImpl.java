package com.codegym.ajax.service.impl;

import com.codegym.ajax.model.Blog;
import com.codegym.ajax.model.Category;
import com.codegym.ajax.repository.IBlogRepository;
import com.codegym.ajax.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public Blog findByName(String name) {
        return blogRepository.findByNameBlog(name);
    }

    @Override
    public Page<Blog> findAllBlog(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public void saveBlog(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public Blog findById(Integer id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public void removeBlog(Integer id) {
        Blog blog = blogRepository.findById(id).orElse(null);
        blogRepository.delete(blog);
    }

    @Override
    public Blog findAllByCategory(Category category) {
        return blogRepository.findAllByCategory(category);
    }

    @Override
    public List<Blog> findAllByName(String name) {
        return blogRepository.findAllByNameBlogContaining(name);
    }
}
