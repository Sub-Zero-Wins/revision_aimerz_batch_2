package com.ecom.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.ecom.beans.CartItem;
import com.ecom.repo.CartItemRepository;
import com.ecom.repo.CartRepository;

public class CartServiceImpl implements CartService {

	@Autowired
	CartRepository cartRepo;
	
	@Autowired
	CartItemRepository cartItemRepo;
	
	@Override
	public CartItem addCartItem(CartItem item) {
		
		return  cartItemRepo.save(item);
	}

	@Override
	public CartItem removeCartItem(int cartItemId) {
		
	   cartItemRepo.deleteById(cartItemId);
	   return null;
	}

	@Override
	public CartItem updateQuantityOfCartItem(int cartItemId,int quantity) {
		CartItem item= cartItemRepo.findById(cartItemId).get();
		item.setQuantity(quantity);
		 
		return item;
	}

	

}
