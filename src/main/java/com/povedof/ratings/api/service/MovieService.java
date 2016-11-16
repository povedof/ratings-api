package com.povedof.ratings.api.service;

import java.util.List;
import com.povedof.ratings.api.exceptionhandling.AppException;
import com.povedof.ratings.api.resources.Movie;

public interface MovieService {
	
	public List<Movie> getMovies() throws AppException;
	
	public Movie getMovie(int mID) throws AppException;
	
}
