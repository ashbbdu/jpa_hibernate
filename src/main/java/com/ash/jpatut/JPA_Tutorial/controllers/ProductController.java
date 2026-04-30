package com.ash.jpatut.JPA_Tutorial.controllers;

import com.ash.jpatut.JPA_Tutorial.entities.ProductEntity;
import com.ash.jpatut.JPA_Tutorial.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class ProductController {
    private final ProductRepository productRepository;


    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
//    @Autowired
//    private ProductRepository productRepository;

    @GetMapping(path = "/ash")
    public void test () {
        ProductEntity p = ProductEntity.builder().title("ashi").sku("SKU-101010110").title("asfasfa").price(new BigDecimal(110)).build();
        productRepository.save(p);
        System.out.println("Inside");
    }

}
