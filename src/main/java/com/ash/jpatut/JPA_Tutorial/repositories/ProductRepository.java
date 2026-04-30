package com.ash.jpatut.JPA_Tutorial.repositories;

import com.ash.jpatut.JPA_Tutorial.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity , Long> {
}
