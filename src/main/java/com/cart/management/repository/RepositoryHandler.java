package com.cart.management.repository;

import com.cart.management.models.Product;

import java.util.HashSet;

public interface RepositoryHandler {

    Product getProductById(int id) throws ProductNotFound;

    HashSet<Product> getAllProducts();
}
