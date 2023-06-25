package com.cart.management.repository;

import com.cart.management.models.Product;

import java.util.ArrayList;

public interface RepositoryHandler {

    Product getProductById(int id) throws ProductNotFound;

    ArrayList<Product> getAllProducts();
}
