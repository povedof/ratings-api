package com.povedof.ratings.api.service;

import java.util.List;
import com.povedof.ratings.api.resources.Movie;

public interface MovieService {
	
	public List<Movie> getMovies();
	
	public Movie getMovie(int mID);
	
}
