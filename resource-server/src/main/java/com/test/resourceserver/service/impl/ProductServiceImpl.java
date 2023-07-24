package com.test.resourceserver.service.impl;

import com.test.resourceserver.dto.ProductDto;
import com.test.resourceserver.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<ProductDto> getAllProducts() {
        return restTemplate.getForObject("http://localhost:8081/api/v1/products", List.class);
    }
}
