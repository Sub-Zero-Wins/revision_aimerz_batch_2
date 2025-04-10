package com.ecom.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.beans.Cart;
import com.ecom.beans.CartItem;

public interface CartRepository extends JpaRepository<Cart,Integer> {

}
