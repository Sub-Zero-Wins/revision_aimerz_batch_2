package com.lib.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lib.beans.User;

public interface UserRepository extends JpaRepository<User,Integer>{
  
	User findUserByEmail(String email);

}
