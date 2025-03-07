package com.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movie.entities.User;

public interface UserRepository extends JpaRepository<User,Integer> {

}
