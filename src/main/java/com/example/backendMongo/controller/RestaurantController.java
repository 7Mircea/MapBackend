package com.example.backendMongo.controller;

import com.example.backendMongo.model.Restaurant;
import com.example.backendMongo.service.RestaurantService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/restaurants")
@AllArgsConstructor
public class RestaurantController {
    private final RestaurantService restaurantService;

    @GetMapping
    public List<Restaurant> fetchAllRestaurants() {
        return restaurantService.getAllRestaurants();
    }

    @GetMapping("{city}")
    public List<Restaurant> fetchRestaurantByCity(@PathVariable("city") String city) {
        return restaurantService.getRestaurantsByCity(city);
    }
}
