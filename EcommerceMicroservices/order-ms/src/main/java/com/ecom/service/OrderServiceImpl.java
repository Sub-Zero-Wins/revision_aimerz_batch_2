package com.ecom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ecom.beans.Order;
import com.ecom.repo.OrderRepository;

public class OrderServiceImpl implements OrderService {
	
	@Autowired
	OrderRepository orderRepo;

	@Override
	public Order placeOrder(Order order) {
		return orderRepo.save(null);
	}

	@Override
	public boolean cancelOrder(int id) {
		
		
		boolean res= false;
		Order orderUpdate=orderRepo.findById(id).get();
		if(orderUpdate!=null)
		{
			orderUpdate.setStatus("CANCELLED");
			orderRepo.save(orderUpdate);
					
			res=true;
		}
		
		return res;
	
	}

	@Override
	public List<Order> getUsersOrders(int userId) {
		return 	orderRepo.findByUserId(userId);
		
	}

}
