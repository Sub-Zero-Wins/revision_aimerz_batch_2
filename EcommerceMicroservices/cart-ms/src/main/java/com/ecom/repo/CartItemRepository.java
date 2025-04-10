package com.ecom.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.beans.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem,Integer> {
	
}