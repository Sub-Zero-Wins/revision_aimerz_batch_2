package com.movie.entity;

import java.util.Arrays;

//Movie Entity
//Movie Entity
public class Movie {
	
	int id;
	String name;
	String category;
	double rating;
	String[] reviews = new String[10];
	int reviewCount = 0;

	public Movie(int id, String name, String category) {
		this.id = id;
		this.name = name;
		this.category = category;
		this.rating = 0.0;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", name=" + name + ", category=" + category + ", rating=" + rating + ", reviews="
				+ Arrays.toString(reviews) + ", reviewCount=" + reviewCount + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String[] getReviews() {
		return reviews;
	}

	public void setReviews(String[] reviews) {
		this.reviews = reviews;
	}

	public int getReviewCount() {
		return reviewCount;
	}

	public void setReviewCount(int reviewCount) {
		this.reviewCount = reviewCount;
	}

	public Movie(int id, String name, String category, double rating, String[] reviews, int reviewCount) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.rating = rating;
		this.reviews = reviews;
		this.reviewCount = reviewCount;
	}
	
	 public void updateMovie(String name, String category) {
	        this.name = name;
	        this.category = category;
	    }

	    public void addReview(String review, double rating) {
	        if (reviewCount < reviews.length) {
	            reviews[reviewCount++] = review;
	            this.rating = (this.rating * (reviewCount - 1) + rating) / reviewCount;
	        }
	    }

	
	
	
}