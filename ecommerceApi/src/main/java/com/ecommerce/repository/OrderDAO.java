package com.ecommerce.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.beans.Order;


public interface OrderDAO extends JpaRepository<Order,Integer>{

	List<Order> findAllByUserId(int userId);


	
}