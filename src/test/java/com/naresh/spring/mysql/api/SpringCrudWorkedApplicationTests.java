package com.naresh.spring.mysql.api;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.naresh.spring.mysql.api.model.Product;
import com.naresh.spring.mysql.api.repository.ProductRepository;
import com.naresh.spring.mysql.api.service.ProductService;

@SpringBootTest
class SpringCrudWorkedApplicationTests {


	@InjectMocks
	private ProductService productService;

	@Mock
	private ProductRepository productrepository;

	@org.junit.Test
	public void getProductsTest() {
		when(productrepository.findAll())
				.thenReturn(Stream.of(new Product(101, "laptop", "administration"))
						.collect(Collectors.toList()));
		assertEquals(1, productService.getProducts().size());
	}

	@Test
	public void saveProductTest() {
		Product product = new Product(201, "bhavath", "superAdmin");

		when(productrepository.save(product)).thenReturn(product);
		assertEquals(product, productService.saveProduct(product));

	}

	@Test
	public void getProductByNameTest() {
		String name="iphone 10";
	Product product=	productrepository.findByName(name);
		assertEquals(product,  productService.getProductByName(name));;
	}
	
	
	@Test
	public String deleteProductTest() {
		Product product=new Product(201, "bhavath", "superAdmin");
		productrepository.deleteById(43);
		verify(productrepository,times(1)).deleteById(product.getId());
		return "sucessfully deleted";

	
 	}
	
	
	
}
