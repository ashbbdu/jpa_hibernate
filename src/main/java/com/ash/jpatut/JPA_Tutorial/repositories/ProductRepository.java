package com.ash.jpatut.JPA_Tutorial.repositories;

import com.ash.jpatut.JPA_Tutorial.entities.ProductEntity;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.sound.sampled.Port;
import javax.swing.text.html.Option;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity , Long> {

//    custom queries
    public List<ProductEntity> findByTitle(String title);

    public List<ProductEntity> findByCreatedAtBetween(LocalDateTime starDate , LocalDateTime endDate);

//    will return first two result
    public List<ProductEntity> findFirst2ByCreatedAtBetween(LocalDateTime starDate , LocalDateTime endDate);

    public List<ProductEntity> findByCreatedAtAfter(LocalDateTime date);

    public List<ProductEntity> findByQuantityIsNull();

   public List<ProductEntity> findByPriceAndQuantity(BigDecimal price, int quantity);

    public Optional<ProductEntity> findByTitleAndPrice(String title, BigDecimal price);


    public List<ProductEntity>  findBy(Sort sort);


//    @NativeQuery(value = "SELECT id , quantity FROM products") to get a particular col we have to use projection
    @NativeQuery(value = "SELECT * FROM products")
    public List<ProductEntity> getIdAndQuantity();

//    @Query("select p.price , p.title from ProductEntity p where p.price =?1")
//    @Query("select p from ProductEntity p where p.price=?1 order by p.id DESC")
      @Query("select p from ProductEntity p order by p.id ASC")
      public List<ProductEntity> findByPrice(BigDecimal price);


      public List<ProductEntity> findAllByOrderByQuantityDesc();




}
