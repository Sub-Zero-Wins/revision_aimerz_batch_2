package com.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.beans.User;

public interface UserDAO extends JpaRepository<User,Integer> {

	User findUserByEmail(String email);
	

}