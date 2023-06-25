package com.cart.management;

import com.cart.management.cart.Cart;
import com.cart.management.cart.CartHandler;
import com.cart.management.repository.ProductNotFound;
import com.cart.management.repository.ProductRepository;
import com.cart.management.repository.RepositoryHandler;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws ProductNotFound {
        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        applicationContext.refresh();

        //repository
        RepositoryHandler repository = applicationContext.getBean("repositoryBean", ProductRepository.class);
        repository.getAllProducts();
        repository.getProductById(1);
//cart

        CartHandler cart = applicationContext.getBean("cartBean", Cart.class);
        /*cart.addProduct(1);
        cart.addProduct(2);
        cart.addProduct(3);
        cart.delete(1);*/


        applicationContext.close();
    }
}
