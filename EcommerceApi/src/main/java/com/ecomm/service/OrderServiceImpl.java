package com.ecomm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.ecomm.entities.Order;
import com.ecomm.repository.OrderRepository;

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
