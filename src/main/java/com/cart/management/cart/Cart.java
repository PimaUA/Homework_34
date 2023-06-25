package com.cart.management.cart;

import com.cart.management.models.Product;
import com.cart.management.repository.ProductNotFound;
import com.cart.management.repository.ProductRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Scanner;

@Component("cartBean")
@Scope("prototype")
public class Cart implements CartHandler {
    private static final Logger LOGGER = LogManager.getLogger();
    private final ArrayList<Product> cart;
    Scanner userInput;
    @Autowired
    ProductRepository repository;

    public Cart(ArrayList<Product> cart, ProductRepository repository) {
        this.cart = cart;
        this.repository = repository;
    }

    @PostConstruct
    public void init() {
        System.out.println("Cart have been created. Specify what to do with your cart");
        userInput = new Scanner(System.in);
        System.out.println("Enter command");
    }




    //add Scanner
    @Override
    public Product addProduct(int id) throws ProductNotFound {
        Product product = repository.getProductById(id);
        cart.add(product);
        return product;
    }

    //add Scanner
    @Override
    public void delete(int id) throws ProductNotFound {
        int idToDelete = repository.getProductById(id).getId();
        this.cart.remove(idToDelete);}
    }

