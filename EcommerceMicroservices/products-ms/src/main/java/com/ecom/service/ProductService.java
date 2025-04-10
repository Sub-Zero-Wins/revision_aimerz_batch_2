package com.ecom.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.ecom.beans.Product;



public interface ProductService 
{
	 public Product addProduct(Product product); 
	 public boolean updateProduct(Product product,int id);
	 public boolean deleteProduct(int id);
	 public List<Product> getAllProducts();
	 public List<Product> searchProductByName(String name);
	 public List<Product> searchProductByCategory(String category);
	public List<Product> getAllProduct(Pageable pageable);
	 
}
