package com.ecom.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.beans.Product;

public interface ProductRepository extends JpaRepository<Product,Integer> {

	List<Product> findByName(String name);

	List<Product> findByCategory(String category);

	List<Product> findAllProducts();

}
