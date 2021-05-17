package com.codegym.demo.repository;

import com.codegym.demo.model.Blog;
import com.codegym.demo.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IBlogRepository  extends JpaRepository<Blog, Integer> {
    Blog findByNameBlog(String name);
    List<Blog> findAllByCategory(Category category);
}
