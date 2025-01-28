package com.basicApi.hotel.entity;

import javax.persistence.*;

import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "hotel")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    private String name;

    private long rating;
    private String city;

    public String getName() {
        return name;
    }

    public Hotel(String id, String name, long rating, String city) {
        this.id = id;
        this.name = name;
        this.rating = rating;
        this.city = city;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", rating=" + rating +
                ", city='" + city + '\'' +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getRating() {
        return rating;
    }

    public void setRating(long rating) {
        this.rating = rating;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Hotel() {
    }
}
