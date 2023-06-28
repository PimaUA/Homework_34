package com.cart.management.repository;

public class ProductNotFound extends Exception {

    public ProductNotFound() {
        super("The specified product does not exist");
    }
}
