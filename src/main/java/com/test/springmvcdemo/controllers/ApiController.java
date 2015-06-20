package com.test.springmvcdemo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.springmvcdemo.services.googlemaps.GeocodeResponse;
import com.test.springmvcdemo.services.googlemaps.GoogleMapsApi;
import com.test.springmvcdemo.services.googleplaces.GooglePlacesApi;
import com.test.springmvcdemo.services.googleplaces.PlaceDetailsResponse;
import com.test.springmvcdemo.services.googleplaces.PlaceSearchResponse;

@RestController
public class ApiController {
    private static final Logger LOG = LoggerFactory.getLogger(ApiController.class);
    private static final String GPLACES_API_KEY = "AIzaSyBwBOnEAjWHFLyLvJFImWqr1TQAz4uz9NA";
    private static final String STATUS_OK = "OK";

    private final GoogleMapsApi gmapsApi;
    private final GooglePlacesApi gplacesApi;

    @Autowired
    public ApiController(GoogleMapsApi mapsGeocodeApi, GooglePlacesApi gplacesApi) {
        super();
        this.gmapsApi = mapsGeocodeApi;
        this.gplacesApi = gplacesApi;
    }

    @RequestMapping(value = "/address/{pin}", method = RequestMethod.GET)
    public @ResponseBody NearbyRestaurantsResponse findNearbyRestaurants(@PathVariable String pin) {
        GeocodeResponse searchResponse = gmapsApi.search(pin);

        List<NearbyRestaurantsResponse.Restaurant> nearbyRestaurants = new ArrayList<NearbyRestaurantsResponse.Restaurant>();
        
        boolean success = false;
        
        String formattedAddress = pin;
        
        if (searchResponse.getStatus().equals(STATUS_OK)) {
            LOG.info("In resolve address action: " + gmapsApi.search(pin));
            LOG.info("Found Place ID: " + searchResponse.getResult().getPlaceId());
            
            formattedAddress = searchResponse.getResult().getFormattedAddress();

            PlaceDetailsResponse placeDetails = gplacesApi.getPlaceDetails(searchResponse.getResult().getPlaceId(), GPLACES_API_KEY);
            
            if (placeDetails.getStatus().equals(STATUS_OK)) {
                LOG.info("Found place details: " + placeDetails);

                LOG.info("Resolved address for pincode: " + pin + " as: " + placeDetails.getResult().getFormattedAddress());

                String location = searchResponse.getResult().getGeometry().getLocation().getLat() + ","
                        + searchResponse.getResult().getGeometry().getLocation().getLng();

                PlaceSearchResponse placesResult = gplacesApi.nearbySearch(GPLACES_API_KEY, location, "distance", "food|restaurant");

                LOG.info("Found nearby restaurants: " + placesResult.getResults());

                for (PlaceSearchResponse.Result r : placesResult.getResults()) {
                    nearbyRestaurants.add(new NearbyRestaurantsResponse.Restaurant(r.getName(), r.getRating(), r.getVicinity(),
                            humanifyRestaurantOpeningHoursStatus(r)));
                }
                
                success = true;
            }
        }

        return new NearbyRestaurantsResponse(formattedAddress, nearbyRestaurants, success);
    }

    private String humanifyRestaurantOpeningHoursStatus(PlaceSearchResponse.Result r) {
        return r.getOpeningHours() == null ? "NA" : r.getOpeningHours().isOpenNow() ? "Yes" : "No";
    }
}
