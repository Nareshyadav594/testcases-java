package com.naresh.spring.mysql.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naresh.spring.mysql.api.model.Product;
import com.naresh.spring.mysql.api.repository.ProductRepository;

@Service
public class ProductService {
@Autowired
	private ProductRepository productRepository;


// post
 public Product saveProduct(Product product) {
 
return productRepository.save(product);
 }
 
	/*
	 * //list of saveAll is given by jpa public List<Product>
	 * saveProduct(List<Product> products) {
	 * 
	 * return productRepository.saveAll(products); }
	 */

 
 // Get
 public List<Product> getProducts(){
	return productRepository.findAll();
 }

 //Get by id
 public Product  getProductById(int id){
		return productRepository.findById(id).orElse(null);
	 }
 
 
//Get by name  find by name is manually
public Product  getProductByName(String name){
		return productRepository.findByName(name);
	 }
 
 //delete 
 
public String deleteProduct(int id) {
	productRepository.deleteById(id);
	return "successfully deleted"+id;
}
 
 //update 
public Product updateProduct(Product product) {
	Product existingProduct=productRepository.findById(product.getId()).orElse(null);
	existingProduct.setName(product.getName());
	existingProduct.setPrice(product.getPrice());
	existingProduct.setQuantity(product.getQuantity());
	
	return  productRepository.save(existingProduct);
	
}

public List<Product> saveProducts(List<Product> products) {
 	return null;
}
 
 
}
