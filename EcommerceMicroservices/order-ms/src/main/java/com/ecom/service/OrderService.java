package com.ecom.service;

import java.util.List;

import com.ecom.beans.Order;

public interface OrderService 
{
	public Order placeOrder(Order order);
	public List<Order> getUsersOrders(int userId);
	boolean cancelOrder(int id);
	
	

}
