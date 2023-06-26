package com.cart.management.cart;

import com.cart.management.repository.ProductNotFound;

public interface CartHandler {

    void addProduct(int id) throws ProductNotFound;

    void deleteProduct(int id) throws ProductNotFound;
}
