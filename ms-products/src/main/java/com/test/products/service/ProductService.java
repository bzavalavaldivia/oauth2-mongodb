package com.test.products.service;

import com.test.products.entity.Product;

import java.util.List;

public interface ProductService {
    public List<Product> getAllProducts();

    public Product createProduct(Product product);
}
