package com.cart.management;

import com.cart.management.entity.Product;
import com.cart.management.service.CartService;
import com.cart.management.repository.ProductNotFound;
import com.cart.management.repository.ProductRepository;
import com.cart.management.repository.ObjectRepository;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

    public static void main(String[] args) throws ProductNotFound {
        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        //repository
        ObjectRepository<Product>repository = applicationContext.getBean("repositoryBean", ProductRepository.class);
        repository.getAllProducts();
        repository.getProductById(1);

        //cart application
        CartService cartService = applicationContext.getBean("cartService", CartService.class);
        cartService.consoleApp();
        applicationContext.close();
    }
}
