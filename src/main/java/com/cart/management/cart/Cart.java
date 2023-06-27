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
    private final ArrayList<Product> cartList;
    @Autowired
    ProductRepository repository;

    public Cart(ArrayList<Product> cartList, ProductRepository repository) {
        this.cartList = cartList;
        this.repository = repository;
    }

    @PostConstruct
    public void init() {
        System.out.println("Cart have been created.");
        System.out.println("Enter command followed by Enter. Available commands are: --add,--delete,--close");
    }

    public void consoleApp() throws ProductNotFound {
        while (true) {
            Scanner userInput = new Scanner(System.in);
            String input = userInput.nextLine();
            if (input.equals("--add")) {
                System.out.println("input id");
                int id = userInput.nextInt();
                addProduct(id);
            } else if (input.equals("--delete")) {
                System.out.println("input id");
                int id = userInput.nextInt();
                deleteProduct(id);
            } else if (input.equals("--close")) {
                System.out.println("Good bye");
                break;
            } else {
                System.out.println("command not recognized. Try again");
            }
        }
    }

    @Override
    public void addProduct(int id) throws ProductNotFound {
        Product product = repository.getProductById(id);
        cartList.add(product);
        LOGGER.info(product + " have been added to cart");
    }

    @Override
    public void deleteProduct(int id) throws ProductNotFound {
        Product product = repository.getProductById(id);
        if (cartList.contains(product)) {
            this.cartList.remove(product);
            LOGGER.info(product + " have been removed from cart");
        } else {
            System.out.println("Product with id " + product.getId() + " is not available in your cart");
        }
    }
}

