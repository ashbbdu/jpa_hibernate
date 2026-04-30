package com.ash.jpatut.JPA_Tutorial.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "products" ,
        uniqueConstraints = {
                @UniqueConstraint(name = "sku_unique", columnNames = {"sku"}),
                @UniqueConstraint(name = "title_price" , columnNames = {"title_x" , "price"}) // just for testing

},
        indexes = {
//            @Index(name = "idx_sku_price" , columnList = "sku, price") // multi col index
                @Index(name = "idx_sku" , columnList = "sku"),
                @Index(name = "idx_price" , columnList = "price")

        }
)
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false , length = 20)
    private String sku;

    @Column(name = "title_x" )
    private String title;


    @Builder.Default
    private String category = "Chocolates"; // this will only work with builder if we are using @Builder.Default

    private BigDecimal price ;
    private Integer quantity;
    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt ;
    @UpdateTimestamp
    private LocalDateTime updatedAt ;
}
