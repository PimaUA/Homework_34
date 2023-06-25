package com.cart.management;

import com.cart.management.configuration.MyConfiguration;
import com.cart.management.repository.ProductRepository;
import com.cart.management.repository.RepositoryHandler;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext=
                new AnnotationConfigApplicationContext();
        applicationContext.register(MyConfiguration.class);
        applicationContext.refresh();


        RepositoryHandler repository=applicationContext.getBean("repositoryBean", ProductRepository.class);


        applicationContext.close();


    }
}
