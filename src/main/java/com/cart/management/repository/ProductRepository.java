package com.cart.management.repository;

import com.cart.management.models.Product;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.HashSet;

@Component("repositoryBean")
@Repository
public class ProductRepository implements RepositoryHandler {
    private static final Logger LOGGER = LogManager.getLogger();
    private HashSet<Product> productsSet;

    @PostConstruct
    public void init() {
        this.productsSet = new HashSet<>();
        productsSet.add(new Product(1, "Tea", 35));
        productsSet.add(new Product(2, "Coffee", 40));
        productsSet.add(new Product(3, "Donut", 20));
        productsSet.add(new Product(4, "Sandwich", 25));
        productsSet.add(new Product(5, "Juice", 30));
        LOGGER.info("The following list of products created " + productsSet.toString());
    }

    @Override
    public Product getProductById(int id) throws ProductNotFound {
        for (Product eachProduct : productsSet) {
            if (eachProduct.getId() == id) {
                LOGGER.info("Found in repository: " + eachProduct);
                return eachProduct;
            }
        }
        throw new ProductNotFound();
    }

    @Override
    public HashSet<Product> getAllProducts() {
        LOGGER.info("List of all products " + productsSet.toString());
        return productsSet;
    }
}
