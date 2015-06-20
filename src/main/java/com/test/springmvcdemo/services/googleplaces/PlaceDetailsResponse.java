package com.test.springmvcdemo.services.googleplaces;

import java.math.BigDecimal;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "PlaceDetailsResponse")
public class PlaceDetailsResponse {
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
        return "PlaceDetailsResponse [status=" + status + ", result=" + result + "]";
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    public static class Result {
        private String name;
        private String vicinity;
        private String type;

        private String url;
        private String icon;
        private String reference;
        private String id;

        @XmlElement(name = "place_id")
        private String placeId;
        private String scope;

        @XmlElement(name = "adr_address")
        private String adrAddress;

        @XmlElement(name = "formatted_address")
        private String formattedAddress;

        @XmlElement(name = "address_component")
        private List<AddressComponent> addressCoomponents;

        private Geometry geometry;

        public Geometry getGeometry() {
            return geometry;
        }

        public void setGeometry(Geometry geometry) {
            this.geometry = geometry;
        }

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

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
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

        public String getAdrAddress() {
            return adrAddress;
        }

        public void setAdrAddress(String adrAddress) {
            this.adrAddress = adrAddress;
        }

        public String getFormattedAddress() {
            return formattedAddress;
        }

        public void setFormattedAddress(String formattedAddress) {
            this.formattedAddress = formattedAddress;
        }

        public List<AddressComponent> getAddressCoomponents() {
            return addressCoomponents;
        }

        public void setAddressCoomponents(List<AddressComponent> addressCoomponents) {
            this.addressCoomponents = addressCoomponents;
        }

        @Override
        public String toString() {
            return "Result [name=" + name + ", vicinity=" + vicinity + ", type=" + type + ", url=" + url + ", icon=" + icon + ", reference="
                    + reference + ", id=" + id + ", placeId=" + placeId + ", scope=" + scope + ", adrAddress=" + adrAddress + ", formattedAddress="
                    + formattedAddress + ", addressCoomponents=" + addressCoomponents + ", geometry=" + geometry + "]";
        }
    }

    @XmlRootElement
    @XmlAccessorType(XmlAccessType.FIELD)
    public static class AddressComponent {
        private String longName;
        private String shortName;
        private String type;

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

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        @Override
        public String toString() {
            return "AddressComponent [longName=" + longName + ", shortName=" + shortName + ", type=" + type + "]";
        }
    }

    @XmlRootElement
    @XmlAccessorType(XmlAccessType.FIELD)
    public static class Geometry {
        private Location location;
        private Viewport viewport;

        public Location getLocation() {
            return location;
        }

        public void setLocation(Location location) {
            this.location = location;
        }

        public Viewport getViewport() {
            return viewport;
        }

        public void setViewport(Viewport viewport) {
            this.viewport = viewport;
        }

        @Override
        public String toString() {
            return "Geometry [location=" + location + ", viewport=" + viewport + "]";
        }
    }

    @XmlRootElement
    @XmlAccessorType(XmlAccessType.FIELD)
    public static class Viewport {
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
            return "Viewport [southwest=" + southwest + ", northeast=" + northeast + "]";
        }
    }

    @XmlRootElement
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
}
