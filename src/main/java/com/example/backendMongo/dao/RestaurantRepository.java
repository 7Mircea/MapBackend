package com.example.backendMongo.dao;

import com.example.backendMongo.model.Restaurant;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface RestaurantRepository
        extends MongoRepository<Restaurant, String> {
    Optional<Restaurant> findRestaurantByRestaurantLink(String restaurant_link);

    List<Restaurant> findRestaurantByCity(String city);

    List<Restaurant> findRestaurantByCountry(String country);
}
