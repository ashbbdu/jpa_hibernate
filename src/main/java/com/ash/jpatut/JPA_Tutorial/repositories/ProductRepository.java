package com.ash.jpatut.JPA_Tutorial.repositories;

import com.ash.jpatut.JPA_Tutorial.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity , Long> {
}
