package com.cart.management.repository;

import java.util.HashSet;

public interface ObjectRepository<T> {

    T getProductById(int id) throws ProductNotFound;

    HashSet<T> getAllProducts();

    void addProduct(int id) throws ProductNotFound;

    void deleteProduct(int id) throws ProductNotFound;
}
