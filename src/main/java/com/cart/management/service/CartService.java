package com.cart.management.service;

import com.cart.management.entity.Product;
import com.cart.management.repository.ObjectRepository;
import com.cart.management.repository.ProductNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Scanner;

@Component("cartService")
@Scope("prototype")
public class CartService {
    @Autowired
    ObjectRepository <Product> repository;

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

    public void addProduct(int id) throws ProductNotFound {
        repository.addProduct(id);
    }

    public void deleteProduct(int id) throws ProductNotFound {
        repository.deleteProduct(id);
    }
}

