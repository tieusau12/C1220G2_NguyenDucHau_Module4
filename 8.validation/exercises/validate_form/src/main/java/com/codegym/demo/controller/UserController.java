package com.codegym.demo.controller;

import com.codegym.demo.model.User;
import com.codegym.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController {
    @Autowired
   IUserService userService;

    @GetMapping
    public ModelAndView listUser() {
        List<User> userList = userService.findAll();
        return new ModelAndView("index", "userList", userList);
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        return new ModelAndView("create", "users", new User());
    }

    @PostMapping("/create")
    public String saveUser(@Validated @ModelAttribute("users") User user, BindingResult bindingResult, Model model){
      new User().validate(user,bindingResult);
      if (bindingResult.hasErrors()){
          return "/create";
      }else {
          userService.save(user);
          model.addAttribute("message","Created new User");
          return "/create";
      }

    }
}
