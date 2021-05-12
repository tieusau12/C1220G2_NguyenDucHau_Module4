package com.codegym.demo.controller;

import com.codegym.demo.model.Blog;
import com.codegym.demo.model.Category;
import com.codegym.demo.service.BlogService;
import com.codegym.demo.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class BlogController {
    @Autowired
    BlogService blogService;
    @Autowired
    ICategoryService categoryService;

    @ModelAttribute("categories")
    public Iterable<Category> categories(){
        return categoryService.findAll();
    }

    @GetMapping
    public ModelAndView showPage(Pageable pageable) {
        Page<Blog> blogList = blogService.findAll(pageable);
        return new ModelAndView("home", "blogList", blogList);
    }

    @GetMapping("/create")
    public ModelAndView showCreateBlog() {
        return new ModelAndView("/blog/create", "blog", new Blog());
    }

    @PostMapping("/save")
    public String createNewBlog(Blog blog, Model model) {
        blogService.saveBlog(blog);
        model.addAttribute("blog", new Blog());
        model.addAttribute("success", "Created new blog successfully");
        return "/blog/create";
    }

    @GetMapping("/{id}/delete")
    public ModelAndView showDeleteBlog(@PathVariable int id) {
        Blog blog = blogService.findById(id);
        return new ModelAndView("/blog/delete", "blog", blog);
    }

    @PostMapping("/delete")
    public String deleteBlog(Blog blog, RedirectAttributes redirectAttributes, @RequestParam String submit) {
        if (submit.equals("Delete")) {
            blogService.deleteBlogById(blog.getId());
            redirectAttributes.addFlashAttribute("success", "Deleted blog successfully");
        }
        return "redirect:";
    }

    @GetMapping("/{id}/edit")
    public ModelAndView showEditPage(@PathVariable int id) {
        Blog blog = blogService.findById(id);
        return new ModelAndView("/blog/edit", "blog", blog);
    }

    @PostMapping("/edit")
    public String editBlog(Blog blog, RedirectAttributes ra) {
        blogService.saveBlog(blog);
        ra.addFlashAttribute("success", "Updated blog successfully");
        return "redirect:";
    }

    @GetMapping("/{id}/view")
    public ModelAndView showViewPage(@PathVariable int id) {
        Blog blog = blogService.findById(id);
        return new ModelAndView("/blog/view", "blog", blog);
    }
}
