package com.naresh.spring.mysql.api.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.naresh.spring.mysql.api.model.Product;
import com.naresh.spring.mysql.api.service.ProductService;


@RestController
public class ProductController {

	@Autowired
	private ProductService productService;

	// post method
	@PostMapping("/addproduct")
	public Product addProduct(@RequestBody Product product) {
		return productService.saveProduct(product);
	}

	// post method list of

	@PostMapping("/addproducts")
	public List<Product> addProducts(@RequestBody List<Product> products) {
		return productService.saveProducts(products);
	}

	
	@GetMapping("/products")
	public List<Product> findAllProducts() {
		return productService.getProducts();
	}
	// pathVariable
		// http://localhost:9191/products/4
		
	@GetMapping("/productById/{id}")//   need to do url
 	public Product findproductById(@PathVariable int id) {
		return productService.getProductById(id);
	}
	
	
	//  @RequestParam
			// http://localhost:9191/products?id=49&name=naresh
	
	@GetMapping("/product/")// don't  need to do url
 	public Product findproductById(@RequestParam  int id,@RequestParam String name) {
		return productService.getProductById(id);
	}

			
	@GetMapping("/product/{name}") 
	public Product findproductBName(@PathVariable String name) {
		return productService.getProductByName(name);
	}

	@PutMapping("/update")
	public Product updateProduct(@RequestBody Product product) {
		return productService.updateProduct(product);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteProduct(@PathVariable int id) {
		return productService.deleteProduct(id);

	}

}