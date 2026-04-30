package com.ash.jpatut.JPA_Tutorial;

import com.ash.jpatut.JPA_Tutorial.entities.ProductEntity;
import com.ash.jpatut.JPA_Tutorial.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
class JpaTutorialApplicationTests {

	@Autowired
	public ProductRepository productRepository;

	@Test
	void contextLoads() {
	}


	@Test
	void testRepository () {
		ProductEntity product = ProductEntity.builder().price(new BigDecimal(10)).title("New Title")
				.category("juice").sku("SKU-0909").build();
		productRepository.save(product);
	}

}
