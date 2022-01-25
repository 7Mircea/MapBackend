package com.example.backendMongo.service;

import com.example.backendMongo.dao.RestaurantRepository;
import com.example.backendMongo.model.Restaurant;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;

    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    public List<Restaurant> getRestaurantsByCity(String city) {
        return restaurantRepository.findRestaurantByCity(city);
    }

    public List<Restaurant> getRestaurantByCountry(String country) {
        return restaurantRepository.findRestaurantByCountry(country);
    }
}
