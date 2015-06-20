package com.test.springmvcdemo.services.googlemaps;

import java.math.BigDecimal;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "GeocodeResponse")
public class GeocodeResponse {
	private String status;
	private Result result;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "GeocodeResponse [status=" + status + ", result=" + result + "]";
	}

	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlRootElement
	public static class Result {
		private String type;

		@XmlElement(name = "formatted_address")
		private String formattedAddress;

		private List<Address> addresses;

		private Geometry geometry;

		@XmlElement(name = "place_id")
		private String placeId;

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getFormattedAddress() {
			return formattedAddress;
		}

		public void setFormattedAddress(String formattedAddress) {
			this.formattedAddress = formattedAddress;
		}

		public List<Address> getAddresses() {
			return addresses;
		}

		public void setAddresses(List<Address> addresses) {
			this.addresses = addresses;
		}

		public Geometry getGeometry() {
			return geometry;
		}

		public void setGeometry(Geometry geometry) {
			this.geometry = geometry;
		}

		public String getPlaceId() {
			return placeId;
		}

		public void setPlaceId(String placeId) {
			this.placeId = placeId;
		}

		@Override
		public String toString() {
			return "Result [type=" + type + ", formattedAddress="
					+ formattedAddress + ", addresses=" + addresses
					+ ", geometry=" + geometry + ", placeId=" + placeId + "]";
		}
		
	}

	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlRootElement(name = "address_component")
	public static class Address {
		@XmlElement(name = "long_name")
		private String longName;

		@XmlElement(name = "short_name")
		private String shortName;

		private List<String> type;

		public String getLongName() {
			return longName;
		}

		public void setLongName(String longName) {
			this.longName = longName;
		}

		public String getShortName() {
			return shortName;
		}

		public void setShortName(String shortName) {
			this.shortName = shortName;
		}

		public List<String> getType() {
			return type;
		}

		public void setType(List<String> type) {
			this.type = type;
		}

		@Override
		public String toString() {
			return "Address [longName=" + longName + ", shortName=" + shortName
					+ ", type=" + type + "]";
		}
	}

	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlRootElement
	public static class Geometry {
		private Location location;

		@XmlElement(name = "location_type")
		private String locationType;

		private ViewportBounds viewport;
		private ViewportBounds bounds;

		public Location getLocation() {
			return location;
		}

		public void setLocation(Location location) {
			this.location = location;
		}

		public String getLocationType() {
			return locationType;
		}

		public void setLocationType(String locationType) {
			this.locationType = locationType;
		}

		public ViewportBounds getViewport() {
			return viewport;
		}

		public void setViewport(ViewportBounds viewport) {
			this.viewport = viewport;
		}

		public ViewportBounds getBounds() {
			return bounds;
		}

		public void setBounds(ViewportBounds bounds) {
			this.bounds = bounds;
		}

		@Override
		public String toString() {
			return "Geometry [location=" + location + ", locationType="
					+ locationType + ", viewport=" + viewport + ", bounds="
					+ bounds + "]";
		}

	}

	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlRootElement
	public static class ViewportBounds {
		private Location southwest;
		private Location northeast;

		public Location getSouthwest() {
			return southwest;
		}

		public void setSouthwest(Location southwest) {
			this.southwest = southwest;
		}

		public Location getNortheast() {
			return northeast;
		}

		public void setNortheast(Location northeast) {
			this.northeast = northeast;
		}

		@Override
		public String toString() {
			return "ViewportBounds [southwest=" + southwest + ", northeast="
					+ northeast + "]";
		}
	}

	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlRootElement
	public static class Location {
		private BigDecimal lat;
		private BigDecimal lng;

		public BigDecimal getLat() {
			return lat;
		}

		public void setLat(BigDecimal lat) {
			this.lat = lat;
		}

		public BigDecimal getLng() {
			return lng;
		}

		public void setLng(BigDecimal lng) {
			this.lng = lng;
		}

		@Override
		public String toString() {
			return "Location [lat=" + lat + ", lng=" + lng + "]";
		}
	}
}
