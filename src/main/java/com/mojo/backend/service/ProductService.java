package com.mojo.backend.service;

import com.mojo.backend.entity.Product;
import com.mojo.backend.entity.Restaurant;
import com.mojo.backend.repository.ProductRepository;
import com.mojo.backend.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;

    public Product addProduct(Long restaurantId, Product product) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new RuntimeException("Restaurant not found"));
        product.setRestaurant(restaurant);
        return productRepository.save(product);
    }

    public List<Product> getProductsByRestaurant(Long restaurantId) {
        return productRepository.findByRestaurantId(restaurantId);
    }
}
