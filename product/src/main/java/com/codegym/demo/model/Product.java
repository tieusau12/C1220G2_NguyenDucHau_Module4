package com.codegym.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @NotEmpty
    private String name;

    @NotNull(message = "Please provide a price")
    @Min(value = 400, message = "Không được nhập số âm và Lớn hơn 400 $")
    private String productPrice;

    @NotEmpty
    private String madeIn;
    @NotEmpty
    private String brand;
    private String description;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "category_id", referencedColumnName = "categoryId")
    private Category category;

    public Product() {
    }

    public Product(Long productId, @NotEmpty String name, @NotNull(message = "Please provide a price") @Min(value = 400, message = "Không được nhập số âm và Lớn hơn 400 $") String productPrice, @NotEmpty String madeIn, @NotEmpty String brand, String description, Category category) {
        this.productId = productId;
        this.name = name;
        this.productPrice = productPrice;
        this.madeIn = madeIn;
        this.brand = brand;
        this.description = description;
        this.category = category;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getMadeIn() {
        return madeIn;
    }

    public void setMadeIn(String madeIn) {
        this.madeIn = madeIn;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
