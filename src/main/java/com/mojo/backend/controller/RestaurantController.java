package com.mojo.backend.controller;

import com.mojo.backend.entity.Restaurant;
import com.mojo.backend.entity.User;
import com.mojo.backend.service.RestaurantService;
import com.mojo.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {
    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private UserService userService;

    @PostMapping
    public Restaurant createRestaurant(@RequestBody Restaurant restaurant, @RequestParam Long ownerId) {
        User owner = userService.findById(ownerId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Owner not found"));
        return restaurantService.createRestaurant(restaurant, owner);
    }

    @GetMapping
    public List<Restaurant> getAllRestaurants() {
        return restaurantService.getAllRestaurants();
    }
}
