package com.mojo.backend.controller;

import com.mojo.backend.entity.Product;
import com.mojo.backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/{restaurantId}")
    public ResponseEntity<Product> addProduct(@PathVariable Long restaurantId, @RequestBody Product product) {
        return ResponseEntity.ok(productService.addProduct(restaurantId, product));
    }

    @GetMapping("/restaurant/{restaurantId}")
    public ResponseEntity<List<Product>> getProductsByRestaurant(@PathVariable Long restaurantId) {
        return ResponseEntity.ok(productService.getProductsByRestaurant(restaurantId));
    }
}
