package com.movie.entities;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Movie
{   
	@Id
	int movieId;
	String name;
	String description;
	String genre;
	LocalTime duration;
	LocalDate releaseDate;
	String showTimings;
	@OneToMany
	List<Reviews> reviews;
	public void addReviews(Reviews review) {
		this.reviews.add(review);
		
	}
	

}
