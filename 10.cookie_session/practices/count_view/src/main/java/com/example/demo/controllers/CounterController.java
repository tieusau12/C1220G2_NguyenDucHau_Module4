package com.example.demo.controllers;

import com.example.demo.models.MyCounter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("myCounter")
public class CounterController {


    @ModelAttribute("myCounter")
    public MyCounter setUpCounter() {
        return new MyCounter();
    }

    @GetMapping("/")
    public String get(@ModelAttribute("myCounter") MyCounter myCounter) {
        myCounter.increment();
        return "index";
    }
}