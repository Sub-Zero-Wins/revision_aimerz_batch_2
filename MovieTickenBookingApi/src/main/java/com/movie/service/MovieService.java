package com.movie.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.movie.entities.Movie;



public interface MovieService 
{
	 public Movie addMovie(Movie movie); 
	 public boolean updateMovie(Movie movie,int id);
	 public boolean deleteMovie(int id);
	 public List<Movie> getAllMovies();
	 public List<Movie> searchMovieByName(String name);
	 public List<Movie> searchMovieByGenre(String genre);
	public List<Movie> getAllMovie(Pageable pageable);
	 
}
