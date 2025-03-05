package com.movie.repository;

import com.movie.entity.Movie;

//Repository Layer
public class MovieRepository 
{
	Movie[] movies = new Movie[10];
	int count = 0;

	public void addMovie(Movie movie) {
		if (count < movies.length) {
			movies[count++] = movie;
		}
	}

	 public void updateMovie(int id, String name, String category) {
	        Movie movie = findMovieById(id);
	      
	        if (movie != null) {
	            movie.updateMovie(name, category);
	        }

	    }

	    public void deleteMovie(int id) {
	        for (int i = 0; i < count; i++) {
	            if (movies[i].getId() == id) {
	                movies[i] = movies[--count];
	                movies[count] = null;
	                break;
	            }
	        }
	    }

	    public Movie findMovieById(int id) {
	        for (int i = 0; i < count; i++) {
	            if (movies[i].getId() == id) {
	                return movies[i];
	            }
	        }
	        return null;
	    }

	    public Movie[] getAllMovies() {
	        return movies;
	    }

	
	
	
}
