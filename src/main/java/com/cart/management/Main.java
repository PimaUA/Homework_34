package com.cart.management;

import com.cart.management.configuration.MyConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        //ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("applicationContext");
        // context.getBean("",Cart.class);
        //context.getBean("",ProductRepository.class);
        //context.close();

        AnnotationConfigApplicationContext applicationContext=
                new AnnotationConfigApplicationContext();
        applicationContext.register(MyConfiguration.class);
        applicationContext.refresh();

        applicationContext.close();


    }
}
