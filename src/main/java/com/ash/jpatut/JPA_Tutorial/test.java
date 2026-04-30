package com.ash.jpatut.JPA_Tutorial;

import com.ash.jpatut.JPA_Tutorial.entities.ProductEntity;
import com.ash.jpatut.JPA_Tutorial.repositories.ProductRepository;

public class test {

    private final ProductRepository productRepository;

    public test(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }



    public static void main(String[] args) {
        ProductEntity p = ProductEntity.builder().title("ashi").build();
        System.out.println(p.getTitle());
        System.out.println(p.getCategory());

    }
}
