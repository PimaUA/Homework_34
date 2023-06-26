package com.cart.management.models;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Product {
    private int id;
    private String name;
    private double price;
}
