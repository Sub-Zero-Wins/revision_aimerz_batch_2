package com.movie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.movie.entities.Booking;
import com.movie.entities.Movie;
import com.movie.entities.Reviews;
import com.movie.service.BookingService;
import com.movie.service.MovieService;

@RestController
@RequestMapping("/events/user")
public class UserController 
{

	@Autowired
	MovieService service;
	
	@Autowired
	BookingService bookingService;
	
	@GetMapping("/all")
	public List<Movie> getAllMovie(@RequestParam(defaultValue="0") int page,
			@RequestParam(defaultValue="5") int size,
			@RequestParam(defaultValue="price") String sortBy,
			@RequestParam(defaultValue="true") boolean ascending) {

		Sort sort = ascending ? Sort.by(sortBy).ascending() :  Sort.by(sortBy).descending();
		Pageable pageable = PageRequest.of(page, size,sort);
		return  service.getAllMovie(pageable);
	}




    @GetMapping("/search")
	public List<Movie> searchMovieByName(@RequestParam String eventName) {

		return service.searchMovieByName(eventName);
	}
    
    @PostMapping("/booking")
    public Booking bookMovie(@RequestBody Booking booking)
    {
    	return bookingService.makeBooking(booking);
    }
    
    @GetMapping("/cancel/{bookingId}")
    public boolean cancelBookedMovie(@PathVariable int bookingId)
    {
    	return bookingService.cancelBooking(bookingId);
    }
    
    @PostMapping("/review/{name}")
    public String addReview(@RequestBody Reviews review,@PathVariable String name)
    {
    	List<Movie> movies =service.getAllMovies();
    	for(Movie movie:movies)
    	{
    		if(movie.getName().equalsIgnoreCase(name))
    			
    		{
    			movie.addReviews(review);
    			return "review added successfully to movie "+name;
    		}
    	}
    	return  "Movie Not Found";
    }


}
