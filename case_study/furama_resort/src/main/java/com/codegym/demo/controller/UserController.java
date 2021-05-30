package com.codegym.demo.controller;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping
    public String home() {
        return "home";
    }

    @GetMapping("/login")
    public String getLoginPage() {
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        if (authentication==null|| authentication instanceof AnonymousAuthenticationToken){
            return "login";
        }
        return "redirect:/";
    }

    @GetMapping("/403")
    public String getPage403() {
        return "/403";
    }
}
