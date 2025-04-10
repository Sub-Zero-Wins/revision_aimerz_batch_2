package com.ecom.service;

import com.ecom.beans.CartItem;

public interface CartService 
{
	public CartItem addCartItem(CartItem item);
	public CartItem removeCartItem(int cartItemId);
	CartItem updateQuantityOfCartItem(int cartItemId, int quantity);
	

}
