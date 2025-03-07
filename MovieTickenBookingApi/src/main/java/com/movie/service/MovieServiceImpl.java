package com.movie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;

import com.movie.entities.Movie;
import com.movie.repository.MovieRepository;


public class MovieServiceImpl implements MovieService
{

	@Autowired
	MovieRepository movieRepo;

	@Override
	public Movie addMovie(Movie movieuct) {
		return	movieRepo.save(movieuct);
	}

	@Override
	public boolean updateMovie( Movie movieuct,int id) {
		
		boolean res= false;
		if(movieRepo.findById(id)!=null)
		{
			movieRepo.save(movieuct);
			res=true;
		}
		
		return res;
	}

	@Override
	public boolean deleteMovie(int id) {
		boolean res= false;
		if(movieRepo.findById(id)!=null)
		{
			movieRepo.deleteById(id);
			res=true;
		}
		
		return res;
	}

	@Override
	public List<Movie> getAllMovies() {
		return movieRepo.findAll();
	}

	@Override
	public List<Movie> searchMovieByName(String name) {
		
		return movieRepo.findByName(name);
	}

	@Override
	public List<Movie> searchMovieByGenre(String genre) {
		return movieRepo.findByGenre(genre);
	}


	@Override
	public List<Movie> getAllMovie(Pageable pageable) {
		
		return movieRepo.findAllMovies(pageable);
	}

}
