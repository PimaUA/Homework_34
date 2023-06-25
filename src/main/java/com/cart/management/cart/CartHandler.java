package com.cart.management.cart;

import com.cart.management.models.Product;
import com.cart.management.repository.ProductNotFound;

public interface CartHandler {

    Product addProduct(int id) throws ProductNotFound;

    void delete(int id) throws ProductNotFound;
}
