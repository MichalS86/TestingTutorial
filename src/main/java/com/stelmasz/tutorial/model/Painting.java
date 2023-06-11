package com.stelmasz.tutorial.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Painting {

    private int id;
    private String name;
    private float price;
    private float efficiency;

    @JsonCreator
    public Painting(@JsonProperty("id") int id, @JsonProperty("name") String name, @JsonProperty("price") float price, @JsonProperty("efficiency") float efficiency) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.efficiency = efficiency;
    }
}
