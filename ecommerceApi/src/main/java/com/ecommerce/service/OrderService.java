package com.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.beans.Order;
import com.ecommerce.beans.Product;
import com.ecommerce.repository.OrderDAO;
import com.ecommerce.repository.ProductDAO;

@Service
public class OrderService {
	
	@Autowired
    private OrderDAO orderDAO ;
	
	@Autowired
    private ProductDAO productDAO ;

    public Order placeOrder(int userId, int productId, int quantity, double totalPrice) {
        Product product = productDAO.findById(productId).get();
        if (product == null || product.getStock() < quantity) {
            return null;
        }
        product.setStock(product.getStock() - quantity);
        return orderDAO.save(new Order(orderDAO.hashCode(), userId, productId, quantity, totalPrice));
    }

    public List<Order> getUserOrders(int userId) {
        return orderDAO.findAllByUserId(userId);
    }
    
    public List<Order> getAllOrders()
    {
    	return orderDAO.findAll();
    }
}