package com.ecomm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;

import com.ecomm.entities.Product;
import com.ecomm.repository.ProductRepository;

public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductRepository prodRepo;

	@Override
	public Product addProduct(Product product) {
		return	prodRepo.save(product);
	}

	@Override
	public boolean updateProduct( Product product,int id) {
		
		boolean res= false;
		if(prodRepo.findById(id)!=null)
		{
			prodRepo.save(product);
			res=true;
		}
		
		return res;
	}

	@Override
	public boolean deleteProduct(int id) {
		boolean res= false;
		if(prodRepo.findById(id)!=null)
		{
			prodRepo.deleteById(id);
			res=true;
		}
		
		return res;
	}

	@Override
	public List<Product> getAllProducts() {
		return prodRepo.findAll();
	}

	@Override
	public List<Product> searchProductByName(String name) {
		
		return prodRepo.findByName(name);
	}

	@Override
	public List<Product> searchProductByCategory(String category) {
		return prodRepo.findByCategory(category);
	}

	

	@Override
	public List<Product> getAllProduct(Pageable pageable) {
		
		return prodRepo.findAllProducts();
	}

}
