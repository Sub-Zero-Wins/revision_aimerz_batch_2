package com.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movie.entities.Reviews;

public  interface ReviewsRepository extends JpaRepository<Reviews, Integer> {


}