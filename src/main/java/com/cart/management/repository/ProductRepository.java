package com.cart.management.repository;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("repositoryBean")
@Scope("singleton")
public class ProductRepository implements RepositoryHandler {



}
