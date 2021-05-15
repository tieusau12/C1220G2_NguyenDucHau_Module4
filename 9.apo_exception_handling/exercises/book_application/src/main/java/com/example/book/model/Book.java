package com.example.book.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idBook;

    private String nameOfBook;
    private Integer quantity;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private Set<Renter> renterSet;


    public Book() {
    }

    public Set<Renter> getRenterSet() {
        return renterSet;
    }

    public void setRenterSet(Set<Renter> renterSet) {
        this.renterSet = renterSet;
    }

    public Integer getIdBook() {
        return idBook;
    }

    public void setIdBook(Integer idBook) {
        this.idBook = idBook;
    }

    public String getNameOfBook() {
        return nameOfBook;
    }

    public void setNameOfBook(String nameOfBook) {
        this.nameOfBook = nameOfBook;
    }


    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
