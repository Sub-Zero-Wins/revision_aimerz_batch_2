package com.ecomm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecomm.entities.Order;
import com.ecomm.entities.Product;
import com.ecomm.service.OrderService;
import com.ecomm.service.ProductService;

@RestController
@RequestMapping("/events/user")
public class UserController 
{

	@Autowired
	ProductService service;
	
	@Autowired
	OrderService orderService;
	
	@GetMapping("/all")
	public List<Product> getAllProduct(@RequestParam(defaultValue="0") int page,
			@RequestParam(defaultValue="5") int size,
			@RequestParam(defaultValue="price") String sortBy,
			@RequestParam(defaultValue="true") boolean ascending) {

		Sort sort = ascending ? Sort.by(sortBy).ascending() :  Sort.by(sortBy).descending();
		Pageable pageable = PageRequest.of(page, size,sort);
		return  service.getAllProduct(pageable);
	}




    @GetMapping("/search")
	public List<Product> searchProductByName(@RequestParam String eventName) {

		return service.searchProductByName(eventName);
	}
    
    @PostMapping("/order")
    public Order bookProduct(@RequestBody Order order)
    {
    	return orderService.placeOrder(order);
    }
    
    @GetMapping("/cancel/{bookingId}")
    public boolean cancelBookedProduct(@PathVariable int bookingId)
    {
    	return orderService.cancelOrder(bookingId);
    }
    


}
