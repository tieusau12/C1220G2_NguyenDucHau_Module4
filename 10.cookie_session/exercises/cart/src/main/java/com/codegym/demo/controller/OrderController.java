package com.codegym.demo.controller;

import com.codegym.demo.model.Cart;
import com.codegym.demo.model.OrderProduct;
import com.codegym.demo.model.OrderProductDetail;
import com.codegym.demo.model.Product;
import com.codegym.demo.service.IOrderProductDetailService;
import com.codegym.demo.service.IOrderProductService;
import com.codegym.demo.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;

@Controller
@SessionAttributes("cart")
public class OrderController {
    @Autowired
    private IOrderProductService orderProductService;

    @Autowired
    private IProductService productService;

    @Autowired
    private IOrderProductDetailService orderProductDetailService;

    @ModelAttribute("cart")
    public Cart cart() {
        return new Cart();
    }

    @GetMapping("/{id}/addtocart")
    public String addProductToCart(@PathVariable Integer id, Cart cart, Model model) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        if (product == null) {
            return "/error-page";
        } else {
            cart.addToCart(product);
            model.addAttribute("message", "Add " + product.getNameProduct() + " to cart successfully : " + cart.getQuantity(product));
        }
        return "redirect:/";
    }

    @GetMapping("/cart")
    public String showCart(Model model, Cart cart) {
        double totalCost = cart.getTotalCost();
        model.addAttribute("totalCost", totalCost);
        model.addAttribute("orderList", cart.getCart());
        return "showCart";
    }

//    @GetMapping("/updateCart")
//    public String updateCart(@PathVariable Integer id, @ModelAttribute Cart cart, Model model) {
//        Product product = productService.findById(id);
//        String nameProduct = product.getNameProduct();
//        Integer quantityProduct = cart.getQuantity(product);
//        model.addAttribute("idProduct",id);
//        model.addAttribute("nameProduct",nameProduct);
//        model.addAttribute("quantityProduct",quantityProduct);
//        return "redirect:/cart";
//    }

//    @GetMapping("/deleteOrder")
//    public String deleteOrder(@RequestParam Integer id, @ModelAttribute Cart cart) {
//
//        if (id != -1) {
//            for (int i = 0; i < cart.getOrderProductDetails().size(); i++) {
//
//                OrderProductDetail orderProductDetail = cart.getOrderProductDetails().get(i);
//
//                if (orderProductDetail.getIdOrderProductDetail() == id) {
//
//                    OrderProduct orderProduct = orderProductDetail.getOrderProduct();
//
//                    orderProductDetailService.deleteOrderProductDetail(id);
//                    orderProductService.deleteOrder(orderProduct);
//
//                    cart.getOrderProductDetails().remove(i);
//
//                }
//            }
//        } else {
//            cart.setOrderProductDetails(new ArrayList<>());
//        }
//        return "redirect:/cart";
//    }
}
