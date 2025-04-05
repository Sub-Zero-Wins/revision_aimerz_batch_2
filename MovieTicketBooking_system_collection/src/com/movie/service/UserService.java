package com.movie.service;

import java.util.List;

import com.movie.entity.Booking;
import com.movie.entity.Movie;
import com.movie.repository.BookingRepository;
import com.movie.repository.MovieRepository;
import com.movie.repository.UserRepository;

public class UserService {
	MovieRepository movieRepo;
	UserRepository userRepo;
	BookingRepository bookingRepo;

	public UserService(MovieRepository movieRepo, UserRepository userRepo, BookingRepository bookingRepo) {
		this.movieRepo = movieRepo;
		this.userRepo = userRepo;
		this.bookingRepo = bookingRepo;
	}
	 public UserService(MovieRepository movieRepo, UserRepository userRepo) {
	        this.movieRepo = movieRepo;
	        this.userRepo = userRepo;
	    }


	public void viewMovies() {
		List<Movie> movies = movieRepo.getAllMovies();
		for (Movie movie : movies) {
			if (movie != null)
				System.out.println(movie.getId() + ". " + movie.getName() + " (" + movie.getCategory() + ") - Rating: " + movie.getRating());
		}
	}

	public void bookTicket(String username, int movieId) {
		Movie movie = movieRepo.findMovieById(movieId);
		if (movie != null) {
			bookingRepo.bookTicket(new Booking(username, movie));
			System.out.println("Ticket booked successfully!");
		} else {
			System.out.println("Movie not found!");
		}
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
