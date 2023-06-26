package com.cart.management;

import com.cart.management.cart.Cart;
import com.cart.management.repository.ProductNotFound;
import com.cart.management.repository.ProductRepository;
import com.cart.management.repository.RepositoryHandler;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) throws ProductNotFound {
        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        //repository
        RepositoryHandler repository = applicationContext.getBean("repositoryBean", ProductRepository.class);
        repository.getAllProducts();
        repository.getProductById(1);

        //cart application
        Cart cart = applicationContext.getBean("cartBean", Cart.class);
        cart.consoleApp();
        applicationContext.close();
    }
}
