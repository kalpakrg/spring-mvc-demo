package com.test.springmvcdemo.services.googleplaces;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Path("/maps/api/place/")
public interface GooglePlacesApi {
    @Path("/details/xml")
    @GET
    PlaceDetailsResponse getPlaceDetails(@QueryParam("placeid") String placeId, @QueryParam("key") String apiKey);

    @GET
    @Path("/nearbysearch/xml")
    PlaceSearchResponse nearbySearch(@QueryParam("key") String key, @QueryParam("location") String location, @QueryParam("rankby") String rankby,
            @QueryParam("types") String types);
}
