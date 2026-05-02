package com.ash.jpatut.JPA_Tutorial;

import com.ash.jpatut.JPA_Tutorial.entities.ProductEntity;
import com.ash.jpatut.JPA_Tutorial.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class JpaTutorialApplicationTests {

	@Autowired
	public ProductRepository productRepository;

	@Test
	void contextLoads() {
	}


	@Test
	void testRepository () {
		ProductEntity product = ProductEntity.builder().price(new BigDecimal(1011111)).title("New Title")
				.category("juice").quantity(110).sku("SKU-02112119019111").build();
//		ProductEntity savedProduct = productRepository.save(product);
//		System.out.println(savedProduct);
	}

	@Test
	void getRepository () {
		List<ProductEntity> products = productRepository.findAll();
//		System.out.println(products);
	}


//	custom queries
	@Test
	void getRepositoryCustom () {
		List<ProductEntity> products = productRepository.findByTitle("Parle G");
//		System.out.println(products);
	}

	@Test
	void getRepositoryByDates () {
		List<ProductEntity> products = productRepository.
				findByCreatedAtBetween(LocalDateTime.of(2026, 5, 1, 0, 0 , 0),
				LocalDateTime.of(2026, 5, 2, 0 ,0, 0));

		System.out.println(products);
	}

//	will return first two First2
	@Test
	void getRepositoryByDatesFirstTwo () {
		List<ProductEntity> products = productRepository.
				findFirst2ByCreatedAtBetween(LocalDateTime.of(2026, 5, 1, 0, 0 , 0),
						LocalDateTime.of(2026, 5, 2, 0 ,0, 0));

		System.out.println(products);
	}

	@Test
	void getAfter () {
		List<ProductEntity> products = productRepository.findByCreatedAtAfter(LocalDateTime.of(2026, 5, 1, 23, 0));
		System.out.println(products);
	}

	@Test
	void getIsNull () {
		List<ProductEntity> products = productRepository.findByQuantityIsNull();
		System.out.println(products);
	}

	@Test
	void getByPriceAndQuantity () {
		List<ProductEntity> products = productRepository.findByPriceAndQuantity(new BigDecimal(101) ,10 );
		System.out.println(products);
	}

	@Test
	void getById () {
		ProductEntity product = productRepository.findById(11L).orElse(null);
		System.out.println(product);
	}

	@Test
	void getByTitleAndPrice () {
		Optional<ProductEntity> product = productRepository.findByTitleAndPrice("Oreo" , new BigDecimal(121));
		product.ifPresent(System.out::println);
	}

//	Native query
	@Test
	void getIdTitle () {
		List<ProductEntity> products = productRepository.getIdAndQuantity();
		System.out.println(products);
	}

	@Test
	void getByPrice () {
		List<ProductEntity> products = productRepository.findByPrice(new BigDecimal(101));
		System.out.println(products);
	}

	@Test
	void getOrderBy () {
		List<ProductEntity> products = productRepository.findAllByOrderByQuantityDesc();
		System.out.println(products);
	}


}
