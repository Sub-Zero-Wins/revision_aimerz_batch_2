package com.ecommerce.service;

import java.util.List;

import com.ecommerce.beans.Order;
import com.ecommerce.beans.Product;
import com.ecommerce.repository.OrderDAO;
import com.ecommerce.repository.ProductDAO;

public class OrderService {
    private OrderDAO orderDAO = new OrderDAO();
    private ProductDAO productDAO = new ProductDAO();

    public boolean placeOrder(int userId, int productId, int quantity, double totalPrice) {
        Product product = productDAO.getProductById(productId);
        if (product == null || product.getStock() < quantity) {
            return false;
        }
        product.setStock(product.getStock() - quantity);
        return orderDAO.addOrder(new Order(orderDAO.hashCode(), userId, productId, quantity, totalPrice));
    }

    public List<Order> getUserOrders(int userId) {
        return orderDAO.getOrdersByUserId(userId);
    }
    
    public List<Order> getAllOrders()
    {
    	return orderDAO.getAllOrders();
    }
}