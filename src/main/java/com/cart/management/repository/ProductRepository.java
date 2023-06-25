package com.cart.management.repository;

import com.cart.management.models.Product;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.HashSet;

@Component("repositoryBean")
@Repository
@Scope("singleton")
public class ProductRepository implements RepositoryHandler {
    private static final Logger LOGGER = LogManager.getLogger();
    private final HashSet<Product> productsSet;
    public ProductRepository() {
        this.productsSet = new HashSet<>();
    }

@PostConstruct
    public void init() {
        productsSet.add(new Product(1,"Tea", 35));
        productsSet.add(new Product(2,"Coffee", 40));
        productsSet.add(new Product( 3,"Donut", 20));
        productsSet.add(new Product( 4,"Sandwich", 25));
        productsSet.add(new Product( 5,"Juice", 30));
    System.out.println("List of products created "+productsSet);
    }

    @Override
    public Product getProductById(int id) throws ProductNotFound {
        for (Product eachProduct : productsSet) {
            if (eachProduct.getId() == id) {
                System.out.println("Product received "+eachProduct);
                return eachProduct;
            }
        }
        throw new ProductNotFound();
    }

    @Override
    public HashSet<Product> getAllProducts() {
        System.out.println("Whole set "+productsSet.toString());
        return productsSet;
    }
}
