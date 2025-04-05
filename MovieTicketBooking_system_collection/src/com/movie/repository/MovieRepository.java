package com.movie.repository;

import java.util.ArrayList;
import java.util.List;

import com.movie.entity.Movie;

//Repository Layer
public class MovieRepository 
{
	List<Movie> movies = new ArrayList<Movie>();
	int count = 0;

	public void addMovie(Movie movie) {
		
			movies.add(movie);
			count++;
		
	}

	 public void updateMovie(int id, String name, String category) {
	        Movie movie = findMovieById(id);
	      
	        if (movie != null) {
	            movie.updateMovie(name, category);
	        }

	    }

	    public void deleteMovie(int id) {
	        for (int i = 0; i < movies.size(); i++) {
	            if (movies.get(i).getId() == id) {
	                movies.remove(i);
	                break;
	            }
	        }
	    }

	    public Movie findMovieById(int id) {
	        for (int i = 0; i < movies.size() ; i++) {
	            if (movies.get(i).getId() == id) {
	                return movies.get(i);
	            }
	        }
	        return null;
	    }

	    public List<Movie> getAllMovies() {
	        return movies;
	    }

	
	
	
}
