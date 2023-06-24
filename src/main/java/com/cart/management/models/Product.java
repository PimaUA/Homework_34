package com.cart.management.models;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("productBean")
@Scope("prototype")
public class Product {

    private long id;
    private String name;
    private double price;
}
