package com.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.beans.Product;
import com.ecommerce.repository.OrderDAO;
import com.ecommerce.repository.ProductDAO;
import com.ecommerce.repository.UserDAO;

@Service
public class ProductService {
	@Autowired
    private ProductDAO productDAO ;
	@Autowired
    private UserDAO userDAO ;
	@Autowired
    private OrderDAO orderDAO ;

    public Product addProduct(int id,String name, double price, int stock) {
        return productDAO.save(new Product(id, name, price, stock));
    }

    public List<Product> getAllProducts() {
        return productDAO.findAll();
    }
    
    public Product addProduct(Product product) {
        return productDAO.save(product);
    }

	public Product updateProduct(Product prod) {
		if(productDAO.findById(prod.getId())!=null)
		{
			return productDAO.save(prod);
		}
		
		return null;
	}

	public String deleteProduct(int prodId) {
		if(productDAO.findById(prodId)!=null)
		{
			 productDAO.deleteById(prodId);
			 return "product deleted with id "+prodId;
		}
		return null;
	}

 
}
