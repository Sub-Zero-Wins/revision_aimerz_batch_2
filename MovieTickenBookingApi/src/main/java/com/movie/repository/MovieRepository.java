package com.movie.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.movie.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer> {

	List<Movie> findByName(String name);

	List<Movie> findByGenre(String genre);
	
	List<Movie> findAllMovies(Pageable pageable);


}