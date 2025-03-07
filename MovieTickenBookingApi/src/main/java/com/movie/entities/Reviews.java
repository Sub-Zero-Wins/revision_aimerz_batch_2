package com.movie.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Reviews 
{
	@Id
	int reviewId;
	int userId;
	Movie movie;
	double rating;
	String review;
	
	

}
