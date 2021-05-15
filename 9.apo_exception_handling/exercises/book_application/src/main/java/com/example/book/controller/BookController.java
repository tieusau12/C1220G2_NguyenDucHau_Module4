package com.example.book.controller;

import com.example.book.model.Book;
import com.example.book.service.IBookService;
import com.example.book.service.IRenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BookController {
    @Autowired
    private IBookService bookService;

    @Autowired
    private IRenterService renterService;

    @GetMapping("/")
    public String showPage(Model model, Pageable pageable) {
        model.addAttribute("listBook", bookService.findAll(pageable));
        return "home";
    }

    @GetMapping("/create")
    public String showCreateBook(Model model) {
        model.addAttribute("book", new Book());
        return "create";
    }

    @PostMapping("/create")
    public String createBook(@ModelAttribute Book book) {
        bookService.createBook(book);
        return "redirect:/";
    }
}
