package com.movie.entity;

//Booking Entity
public class Booking {
	String username;
	Movie movie;

	public Booking(String username, Movie movie) {
		this.username = username;
		this.movie = movie;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	@Override
	public String toString() {
		return "Booking [username=" + username + ", movie=" + movie + "]";
	}
	
	
}