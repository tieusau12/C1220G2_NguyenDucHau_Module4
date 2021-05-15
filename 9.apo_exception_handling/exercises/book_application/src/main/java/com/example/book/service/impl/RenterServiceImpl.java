package com.example.book.service.impl;

import com.example.book.model.Renter;
import com.example.book.repository.IRenterRepository;
import com.example.book.service.IRenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RenterServiceImpl implements IRenterService {
    @Autowired
    private IRenterRepository renterRepository;

    @Override
    public Renter findById(Integer id) {
        return renterRepository.findById(id).orElse(null);
    }

    @Override
    public void removeRenter(Renter renter) {
        renterRepository.delete(renter);
    }

    @Override
    public void createRenter(Renter renter) {
        renterRepository.save(renter);
    }
}
