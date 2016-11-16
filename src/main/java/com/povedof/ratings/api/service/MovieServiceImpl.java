package com.povedof.ratings.api.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.povedof.ratings.api.dao.MovieDAO;
import com.povedof.ratings.api.entity.MovieEntity;
import com.povedof.ratings.api.exceptionhandling.AppException;
import com.povedof.ratings.api.resources.Movie;
import javax.ws.rs.core.Response;

@Service
public class MovieServiceImpl implements MovieService {

	// need to inject movie dao
	@Autowired
	private MovieDAO movieDAO;
 
	@Override
	@Transactional
	public List<Movie> getMovies() throws AppException {
		try{
			return getMoviesFromEntities(movieDAO.getMovies());
		}
		catch(Exception e){
			throw new AppException(Response.Status.CONFLICT.getStatusCode(), 
					               409,
					               "Could not retrieve movies from data base",
					               e.getMessage());
		}
	}
	
	@Override
	@Transactional
	public Movie getMovie(int mID) throws AppException {
		try{
			return new Movie(movieDAO.getMovie(mID));
		}
		catch(Exception e){
			throw new AppException(Response.Status.CONFLICT.getStatusCode(), 
					               409,
					               "Movie with id " + mID + " does not exist",
					               e.getMessage());
		}
	}

	private List<Movie> getMoviesFromEntities(List<MovieEntity> movieEntities) {
		List<Movie> response = new ArrayList<Movie>();
		for(MovieEntity movieEntity : movieEntities){
			response.add(new Movie(movieEntity));					
		}
		return response;
	}
}
