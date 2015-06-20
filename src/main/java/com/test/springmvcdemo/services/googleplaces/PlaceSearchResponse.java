package com.test.springmvcdemo.services.googleplaces;

import java.math.BigDecimal;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "PlaceSearchResponse")
public class PlaceSearchResponse {
    private String status;

    @XmlElement(name = "html_attribution")
    private String htmlAttribution;

    @XmlElement(name = "next_page_token")
    private String nextPageToken;

    @XmlElement(name = "result")
    private List<Result> results;

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getHtmlAttribution() {
        return htmlAttribution;
    }

    public void setHtmlAttribution(String htmlAttribution) {
        this.htmlAttribution = htmlAttribution;
    }

    public String getNextPageToken() {
        return nextPageToken;
    }

    public void setNextPageToken(String nextPageToken) {
        this.nextPageToken = nextPageToken;
    }

    @Override
    public String toString() {
        return "PlaceSearchResponse [status=" + status + ", htmlAttribution=" + htmlAttribution + ", nextPageToken=" + nextPageToken + ", results="
                + results + "]";
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    public static class Result {
        private String name;
        private String vicinity;
        private double rating;
        private String icon;
        private String reference;
        private String id;

        @XmlElement(name = "opening_hours")
        private OpeningHours openingHours;

        private Photo photo;

        private Geometry geometry;

        @XmlElement(name = "place_id")
        private String placeId;
        private String scope;

        @XmlElement(name = "type")
        private List<String> types;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getVicinity() {
            return vicinity;
        }

        public void setVicinity(String vicinity) {
            this.vicinity = vicinity;
        }

        public double getRating() {
            return rating;
        }

        public void setRating(double rating) {
            this.rating = rating;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getReference() {
            return reference;
        }

        public void setReference(String reference) {
            this.reference = reference;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public OpeningHours getOpeningHours() {
            return openingHours;
        }

        public void setOpeningHours(OpeningHours openingHours) {
            this.openingHours = openingHours;
        }

        public Photo getPhoto() {
            return photo;
        }

        public void setPhoto(Photo photo) {
            this.photo = photo;
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

        public String getScope() {
            return scope;
        }

        public void setScope(String scope) {
            this.scope = scope;
        }

        public List<String> getTypes() {
            return types;
        }

        public void setTypes(List<String> types) {
            this.types = types;
        }

        @Override
        public String toString() {
            return "Result [name=" + name + ", vicinity=" + vicinity + ", rating=" + rating + ", icon=" + icon + ", reference=" + reference + ", id="
                    + id + ", openingHours=" + openingHours + ", photo=" + photo + ", geometry=" + geometry + ", placeId=" + placeId + ", scope="
                    + scope + ", types=" + types + "]";
        }

    }

    @XmlAccessorType(XmlAccessType.FIELD)
    public static class OpeningHours {
        @XmlElement(name = "open_now")
        private boolean openNow;

        public boolean isOpenNow() {
            return openNow;
        }

        public void setOpenNow(boolean openNow) {
            this.openNow = openNow;
        }

        @Override
        public String toString() {
            return "OpeningHours [openNow=" + openNow + "]";
        }

    }

    @XmlAccessorType(XmlAccessType.FIELD)
    public static class Geometry {
        private Location location;

        public Location getLocation() {
            return location;
        }

        public void setLocation(Location location) {
            this.location = location;
        }

        @Override
        public String toString() {
            return "Geometry [location=" + location + "]";
        }

    }

    @XmlAccessorType(XmlAccessType.FIELD)
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

    @XmlAccessorType(XmlAccessType.FIELD)
    public static class Photo {
        @XmlElement(name = "photo_reference")
        private String photoReference;
        private int width;
        private int heigth;

        public String getPhotoReference() {
            return photoReference;
        }

        public void setPhotoReference(String photoReference) {
            this.photoReference = photoReference;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public int getHeigth() {
            return heigth;
        }

        public void setHeigth(int heigth) {
            this.heigth = heigth;
        }

        @Override
        public String toString() {
            return "Photo [photoReference=" + photoReference + ", width=" + width + ", heigth=" + heigth + "]";
        }
    }
}
