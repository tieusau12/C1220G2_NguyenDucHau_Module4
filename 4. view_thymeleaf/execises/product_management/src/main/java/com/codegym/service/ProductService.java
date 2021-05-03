package com.codegym.service;

import com.codegym.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService implements IProductService{
    private static final Map<Integer,Product> products;
    static {
        products = new HashMap<>();
        products.put(1,new Product(7,"Iphone 7",500.0,"Gold 32GB","Apple"));
        products.put(2,new Product(8,"Iphone 8 Plus",600.0,"Black 65GB","Apple"));
        products.put(3,new Product(10,"Iphone X",700.0,"Red 64GB","Apple"));
        products.put(4,new Product(11,"Iphone 11 Pro Max",900.0,"Gold 256GB","Apple"));
        products.put(5,new Product(12,"Iphone 12 Pro Max",1200.0,"Black 256GB","Apple"));
        products.put(6,new Product(13,"Iphone 13 Pro",1500.0,"White 512GB","Apple"));
    }
    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save( Product product) {
        products.put(product.getId(),product);
    }


    @Override
    public Product findById(Integer id) {
        return products.get(id);
    }

    @Override
    public void update(Integer id, Product product) {
        products.put(id,product);
    }

    @Override
    public void remove(Integer id) {
        products.remove(id);
    }
}
