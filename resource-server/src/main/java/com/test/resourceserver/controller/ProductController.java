package com.test.resourceserver.controller;

import com.test.resourceserver.dto.ProductDto;
import com.test.resourceserver.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ROLE_USER')")
    public List<ProductDto> getAllProducts() {
        return productService.getAllProducts();
    }
}
