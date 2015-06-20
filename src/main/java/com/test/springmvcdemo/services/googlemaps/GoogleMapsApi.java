package com.test.springmvcdemo.services.googlemaps;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Path("/maps/api")
public interface GoogleMapsApi {
	@Path("/geocode/xml")
	@GET
	GeocodeResponse search(@QueryParam("address") String address);
}
