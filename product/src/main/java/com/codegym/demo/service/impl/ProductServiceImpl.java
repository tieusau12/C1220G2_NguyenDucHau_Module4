package com.codegym.demo.service.impl;

import com.codegym.demo.model.Product;
import com.codegym.demo.repository.ICategoryRepository;
import com.codegym.demo.repository.IProductRepository;
import com.codegym.demo.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService<Product> {
    @Autowired
    private IProductRepository productRepository;


    @Override
    public Page<Product> findThreeField(int pageNum, String sortField, String sortDir, String name, String brand, String categoryName) {
        Sort sort = Sort.by(sortField);
        sort = sortDir.equals("asc") ? sort.ascending() : sort.descending();
        Pageable pageable = PageRequest.of(pageNum - 1, 5, sort);
        if (name != null || brand != null || categoryName != null) {
            return productRepository.getByNameContainingAndBrandContainingAndCategory_CategoryNameContaining(name, brand, categoryName, pageable);
        }
       return productRepository.findAll(pageable);
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> findTop5() {
        return productRepository.findTop5ByOrderByProductPriceDesc();
    }

}
