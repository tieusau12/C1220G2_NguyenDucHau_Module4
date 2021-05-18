package com.codegym.ajax.repository;

import com.codegym.ajax.model.Blog;
import com.codegym.ajax.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    Blog findByNameBlog(String name);

    Blog findAllByCategory(Category category);

    List<Blog> findAllByNameBlogContaining(String name);
}
