package com.ecom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.beans.Product;
import com.ecom.service.ProductService;

@RestController
@RequestMapping("/Products/admin")
public class ProductController
{
	@Autowired
	ProductService service;
	
	
	@PostMapping("/add")
	public Product addProduct(@RequestBody Product Product) {

		return service.addProduct(Product);
	}

	@PutMapping("/update/{ProductId}")
	public boolean updateProduct(@RequestBody Product Product, @PathVariable int ProductId) {
		return service.updateProduct(Product, ProductId);
	}

	@DeleteMapping("/delete/{ProductId}")
	public boolean deleteProduct(@PathVariable int id) {
		return service.deleteProduct(id);
	}

   
}
