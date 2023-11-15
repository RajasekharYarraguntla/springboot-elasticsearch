package com.raja.controller;

import com.raja.entity.Product;
import com.raja.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<Iterable<Product>> findAll() {
        return ResponseEntity.ok(productService.getAll());
    }

    @PostMapping("/products")
    public ResponseEntity<Iterable<Product>> insertProduct(@RequestBody Product product) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.saveProduct(product));
    }


    @DeleteMapping("/products")
    public ResponseEntity<Object> deleteAll() {
        productService.deleteAll();
        return ResponseEntity.noContent().build();
    }
}
