package com.ecomm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecomm.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

	List<Order> findByUserId(int userId);

}
