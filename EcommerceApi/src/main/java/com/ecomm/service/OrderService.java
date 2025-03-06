package com.ecomm.service;

import java.util.List;

import com.ecomm.entities.Order;

public interface OrderService 
{
	public Order placeOrder(Order order);
	public List<Order> getUsersOrders(int userId);
	boolean cancelOrder(int id);
	
	

}
