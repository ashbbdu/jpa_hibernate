package com.ash.jpatut.JPA_Tutorial.repositories;

import com.ash.jpatut.JPA_Tutorial.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity , Long> {

//    custom queries
    public List<ProductEntity> findByTitle(String title);

    public List<ProductEntity> findByCreatedAtBetween(LocalDateTime starDate , LocalDateTime endDate);

//    will return first two result
    public List<ProductEntity> findFirst2ByCreatedAtBetween(LocalDateTime starDate , LocalDateTime endDate);

    public List<ProductEntity> findByCreatedAtAfter(LocalDateTime date);

    public List<ProductEntity> findByQuantityIsNull();

}
