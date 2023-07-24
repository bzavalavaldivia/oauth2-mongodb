package com.test.resourceserver.service;

import com.test.resourceserver.dto.ProductDto;

import java.util.List;

public interface ProductService {
    public List<ProductDto> getAllProducts();
}
