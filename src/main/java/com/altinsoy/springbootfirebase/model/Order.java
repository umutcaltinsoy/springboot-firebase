package com.altinsoy.springbootfirebase.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    private Integer type;
    private Integer quantity;
    private boolean extraFrosting;
    private boolean addSprinkles;
    private String name;
    private String streetAdress;
    private String city;
    private String zip;
}
