package com.codegym.demo.controller;

import com.codegym.demo.model.Category;
import com.codegym.demo.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @GetMapping
    public ModelAndView showListCategory() {
        return new ModelAndView("/category/list-category", "category", categoryService.findAll());
    }

    @GetMapping("/create-category")
    public ModelAndView showCreateCategory() {
        return new ModelAndView("/category/create-category", "category", new Category());
    }

    @PostMapping("/create")
    public String createNewCategory(Category category, Model model) {
        categoryService.save(category);
        model.addAttribute("message", "successfully");
        model.addAttribute("category", new Category());
        return "/category/create-category";
    }

    @GetMapping("/{id}/edit")
    public ModelAndView showEditCategory(@PathVariable Integer id) {
        return new ModelAndView("/category/edit-category", "category", categoryService.findById(id));
    }

    @PostMapping("/edit")
    public String editCategory(Category category) {
        categoryService.save(category);
        return "redirect:";
    }

    @GetMapping("/{id}/delete")
    public ModelAndView showDeleteCategory(@PathVariable Integer id){
        return new ModelAndView("/category/delete-category","category",categoryService.findById(id));
    }
    @PostMapping("/delete")
    public String deleteCategory(Category category , RedirectAttributes ra, @RequestParam String submit){
        if(submit.equals("Delete")){
            categoryService.deleteById(category.getId());
            ra.addFlashAttribute("msg","successfully");
        }
        return "redirect:";
    }
}
