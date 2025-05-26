package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.beans.Order;
import com.ecommerce.beans.Product;
import com.ecommerce.service.OrderService;
import com.ecommerce.service.ProductService;

@RestController
@RequestMapping("/api/user")
public class UserController 
{
	@Autowired
	ProductService prodService;
	
	@Autowired
	OrderService orderService;

	@GetMapping("/allProds")
	public List<Product> viewProducts()
	{
		return prodService.getAllProducts();
	}
	
	@PostMapping("/placeOrder")
	public void placeOrder(@RequestBody Order order)
	{
		orderService.placeOrder(order.getUserId(), order.getProductId(), order.getQuantity(), order.getTotalPrice());
	}
	
	@GetMapping("/allOrders/{userId}")
	public void viewMyOrders(@PathVariable int userId)
	{
		orderService.getUserOrders(userId);
	}
	
	public void searchProducts()
	{
		
	}
	
	public void searchProductsByCategory()
	{
		
	}
}

