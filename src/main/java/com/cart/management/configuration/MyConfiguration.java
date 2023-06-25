package com.cart.management.configuration;

import com.cart.management.repository.ProductRepository;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Repository;

@Configuration
@PropertySource("classpath:myApp.properties")
public class MyConfiguration {

@Bean

 public ProductRepository repositoryBean(){
    return new ProductRepository();
 }



}
