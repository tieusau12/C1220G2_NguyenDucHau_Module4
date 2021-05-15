package com.example.book.repository;

import com.example.book.model.Renter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRenterRepository extends JpaRepository<Renter, Integer> {
}
