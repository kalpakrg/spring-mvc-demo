package com.test.springmvcdemo.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NearbyRestaurantsResponse {
    private final String address;
    private final List<Restaurant> restaurants;

    public NearbyRestaurantsResponse(String address, List<Restaurant> restaurants) {
        super();
        this.address = address;
        this.restaurants = new ArrayList<Restaurant>(restaurants);
    }

    public String getAddress() {
        return address;
    }

    public List<Restaurant> getRestaurants() {
        return Collections.unmodifiableList(restaurants);
    }

    public static class Restaurant {
        private final String name;
        private final double rating;
        private final String vicinity;
        private final String openNowStatus;

        public Restaurant(String name, double rating, String vicinity, String openNowStatus) {
            super();
            this.name = name;
            this.rating = rating;
            this.vicinity = vicinity;
            this.openNowStatus = openNowStatus;
        }

        public String getName() {
            return name;
        }

        public double getRating() {
            return rating;
        }

        public String getVicinity() {
            return vicinity;
        }

        public String getOpenNowStatus() {
            return openNowStatus;
        }
    }
}
