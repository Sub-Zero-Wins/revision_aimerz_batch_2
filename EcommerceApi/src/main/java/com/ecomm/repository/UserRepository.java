package com.ecomm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecomm.entities.User;

public interface UserRepository extends JpaRepository<User,Integer> {

}
