package com.example.book.service;

import com.example.book.model.Renter;

public interface IRenterService {
    Renter findById(Integer id);

    void removeRenter(Renter renter);

    void createRenter(Renter renter);
}
