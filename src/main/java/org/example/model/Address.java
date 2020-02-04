package org.example.model;


import javax.persistence.Embeddable;

/**
 * Class which is mapped to the database table (USER_INFO)of its owing entity class
 */
@Embeddable
public class Address  {
    /**
     * pin
     * state
     * city
     * country
     * zip code
     */
    private String state;
    private String city;
    private String country;

    private String zipCode;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        System.out.println("City name is "+city);
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
