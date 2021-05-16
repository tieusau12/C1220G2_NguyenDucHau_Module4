package com.codegym.demo.controller;

import com.codegym.demo.model.Cart;
import com.codegym.demo.model.Category;
import com.codegym.demo.model.Product;
import com.codegym.demo.service.ICategoryService;
import com.codegym.demo.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
@RequestMapping("/product")
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private IProductService productService;

    @Autowired
    private ICategoryService categoryService;

    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }

    @ModelAttribute("category")
    public List<Category> categoryList() {
        return categoryService.findAll();
    }

    @GetMapping
    public String showHomePage(@PageableDefault(value = 3) Pageable pageable, Model model) {
        model.addAttribute("products", productService.findAll(pageable));
        return "home";
    }

    @GetMapping("/create")
    public ModelAndView showCreateProductPage() {
        return new ModelAndView("/product/create-product", "product", new Product());
    }

    @PostMapping("/create")
    public String createNewProduct(Product product, Model model) {
        productService.saveProduct(product);
        model.addAttribute("message", "successfully");
        model.addAttribute("product", new Product());
        return "/product/create-product";
    }

    @GetMapping("/{id}/edit")
    public ModelAndView showEditProductPage(@PathVariable Integer id) {
        return new ModelAndView("/product/edit-product", "product", productService.findById(id));
    }

    @PostMapping("/edit")
    public String editProduct(Product product, RedirectAttributes redirectAttributes) {
        productService.saveProduct(product);
        redirectAttributes.addFlashAttribute("msg", "Product updates successfully!!");
        return "redirect:";
    }

    @GetMapping("/{id}/delete")
    public ModelAndView showDeleteProductPage(@PathVariable Integer id) {
        return new ModelAndView("/product/delete-product", "product", productService.findById(id));
    }

    @PostMapping("/delete")
    public String deleteProduct(Product product, @RequestParam String submit) {
        if (submit.equals("Delete")) {
            productService.deleteProduct(product.getId());

        }
        return "redirect:";
    }

    @GetMapping("/{id}/view")
    public ModelAndView showProductInformation(@PathVariable Integer id) {
        return new ModelAndView("/product/view-product", "product", productService.findById(id));
    }

}
