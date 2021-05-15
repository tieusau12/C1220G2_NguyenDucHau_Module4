package com.example.book.service;

import com.example.book.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBookService {
    void createBook(Book book);

    void rentBook(Book book);

    void updateRent(Book book);

    Page<Book> findAll(Pageable pageable);

    Book findById(Integer id);
}
