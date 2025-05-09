package com.ecommerce.service;

import java.util.List;

import com.ecommerce.beans.Product;
import com.ecommerce.repository.OrderDAO;
import com.ecommerce.repository.ProductDAO;
import com.ecommerce.repository.UserDAO;

public class ProductService {
    private ProductDAO productDAO = new ProductDAO();
    private UserDAO userDAO = new UserDAO();
    private OrderDAO orderDAO = new OrderDAO();

    public boolean addProduct(int id,String name, double price, int stock) {
        return productDAO.addProduct(new Product(id, name, price, stock));
    }

    public List<Product> getAllProducts() {
        return productDAO.getAllProducts();
    }
    
    public void addProduct(Product product) {
        productDAO.addProduct(product);
    }

 
}
