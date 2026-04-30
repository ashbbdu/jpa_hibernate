package com.ash.jpatut.JPA_Tutorial;

import com.ash.jpatut.JPA_Tutorial.entities.ProductEntity;
import com.ash.jpatut.JPA_Tutorial.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
class JpaTutorialApplicationTests {

	@Autowired
	public ProductRepository productRepository;

	@Test
	void contextLoads() {
	}


	@Test
	void testRepository () {
		ProductEntity product = ProductEntity.builder().price(new BigDecimal(101111)).title("New Title")
				.category("juice").quantity(10).sku("SKU-0211219019111").build();
		ProductEntity savedProduct = productRepository.save(product);
		System.out.println(savedProduct);
	}

	@Test
	void getRepository () {
		List<ProductEntity> products = productRepository.findAll();
		System.out.println(products);
	}



}
