package com.example.backendMongo.model;

import lombok.Data;

@Data
public class Restaurant {
    private String restaurantLink;
    private String restaurant_name;
    private Location original_location;
    private String country;
    private String region;
    private String province;
    private String city;
    private String address;
    private String latitude;
    private String longitude;

    public Restaurant(String restaurantLink, String restaurant_name, Location original_location, String country, String region, String province, String city, String address, String latitude, String longitude) {
        this.restaurantLink = restaurantLink;
        this.restaurant_name = restaurant_name;
        this.original_location = original_location;
        this.country = country;
        this.region = region;
        this.province = province;
        this.city = city;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
