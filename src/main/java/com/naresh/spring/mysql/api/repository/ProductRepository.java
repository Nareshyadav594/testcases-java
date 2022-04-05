package com.naresh.spring.mysql.api.repository;
 

import org.springframework.data.jpa.repository.JpaRepository;

import com.naresh.spring.mysql.api.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	Product findByName(String name);

}
