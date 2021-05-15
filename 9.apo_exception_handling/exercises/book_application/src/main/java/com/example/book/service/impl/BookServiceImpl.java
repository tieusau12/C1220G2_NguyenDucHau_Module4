package com.example.book.service.impl;

import com.example.book.model.Book;
import com.example.book.repository.IBookRepository;
import com.example.book.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements IBookService {
    @Autowired
    private IBookRepository bookRepository;

    @Override
    public void createBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void rentBook(Book book) {
        book.setQuantity(book.getQuantity() - 1);
        bookRepository.save(book);
    }

    @Override
    public void updateRent(Book book) {
        book.setQuantity(book.getQuantity() + 1);
        bookRepository.save(book);
    }

    @Override
    public Page<Book> findAll(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }

    @Override
    public Book findById(Integer id) {
        return bookRepository.findById(id).orElse(null);
    }
}
