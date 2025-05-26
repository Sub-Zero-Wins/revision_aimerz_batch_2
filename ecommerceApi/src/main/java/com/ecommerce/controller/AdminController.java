package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.beans.Product;
import com.ecommerce.service.ProductService;

@RestController
@RequestMapping("/api/admin")
public class AdminController
{

	@Autowired
	ProductService productService;
	
	@PostMapping("/add")
	public Product addProducts(@RequestBody Product prod)
	{
		return productService.addProduct(prod);
	}
	
	@PutMapping("/update")
	public Product updateProducts(@RequestBody Product prod)
	{
		return productService.updateProduct(prod);
	}
	
	@DeleteMapping("/delete")
	public String deleteProducts(@PathVariable int prodId)
	{
		return productService.deleteProduct(prodId);
	}
	
	@GetMapping("/all")
	public List<Product> getAllProducts()
	{
		return productService.getAllProducts();
	}
	
}
