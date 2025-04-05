package com.movie.service;

import com.movie.entity.Movie;
import com.movie.repository.MovieRepository;

//Service Layer
public class AdminService {
	MovieRepository movieRepo;

	public AdminService(MovieRepository movieRepo) {
		this.movieRepo = movieRepo;
	}

	public void addMovie(int id, String name, String category) {
		Movie movie = new Movie(id, name, category);
		movieRepo.addMovie(movie);
		System.out.println("Movie added successfully!");
	}
	  public void updateMovie(int id, String name, String category) {
	        movieRepo.updateMovie(id, name, category);
	    }

	    public void deleteMovie(int id) {
	        movieRepo.deleteMovie(id);
	    }
	  
	    public void searchMovies(String category) {
	        for (Movie movie : movieRepo.getAllMovies()) {
	            if (movie != null && movie.getCategory().equalsIgnoreCase(category)) {
	                System.out.println(movie.getId() + ". " + movie.getName() + " (" + movie.getCategory() + ")");
	            }
	        }
	    }

	    public void addReview(int movieId, String review, double rating) {
	        Movie movie = movieRepo.findMovieById(movieId);
	        if (movie != null) {
	            movie.addReview(review, rating);
	        }
	    }


}