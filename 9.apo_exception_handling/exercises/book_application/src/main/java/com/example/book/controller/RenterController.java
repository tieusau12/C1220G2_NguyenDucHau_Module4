package com.example.book.controller;

import com.example.book.model.Book;
import com.example.book.model.Renter;
import com.example.book.service.IBookService;
import com.example.book.service.IRenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RenterController {
    @Autowired
    private IBookService bookService;

    @Autowired
    private IRenterService renterService;

    @GetMapping("/{id}/rent")
    public String showRentBook(@PathVariable Integer id, RedirectAttributes redirectAttributes, Model model) {
        Book book = bookService.findById(id);
        if (book.getQuantity() > 0) {
            model.addAttribute("book", book);
            return "showRent";
        }
        redirectAttributes.addFlashAttribute("message", "Quantity of  " +
                book.getNameOfBook() + " has run out");
        return "redirect:/";
    }

    @GetMapping("/{id}/rented")
    public String saveRentBook(@PathVariable Integer id) {
        Book book = bookService.findById(id);

        Renter renter = new Renter();
        renter.setBook(book);

        bookService.rentBook(book);
        renterService.createRenter(renter);
        return "redirect:/";
    }

    @GetMapping("/refundBook")
    public String showRefundBook () {
        return "/refundBook";
    }

    @PostMapping("/refundBook")
    public String refundBook(@RequestParam Integer idRenter, Model model) {
        Renter renter = renterService.findById(idRenter);
        if (renter == null) {
            model.addAttribute("message", "Not found");
            model.addAttribute("idRenter", idRenter);
            return "/refundBook";
        }
        bookService.updateRent(renter.getBook());
        renterService.removeRenter(renter);
        return "redirect:/";
    }

}
