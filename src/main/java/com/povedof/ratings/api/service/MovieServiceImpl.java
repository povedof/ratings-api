package com.povedof.ratings.api.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.povedof.ratings.api.dao.MovieDAO;
import com.povedof.ratings.api.entity.MovieEntity;
import com.povedof.ratings.api.resources.Movie;

@Service
public class MovieServiceImpl implements MovieService {

	// need to inject movie dao
	@Autowired
	private MovieDAO movieDAO;
 
	@Override
	@Transactional
	public List<Movie> getMovies() {
		return getMoviesFromEntities(movieDAO.getMovies());
	}
	
	@Override
	@Transactional
	public Movie getMovie(int mID) {
		try{
			return new Movie(movieDAO.getMovie(mID));	
		}
		catch(Exception e){
			return null;
		}
	}

	private List<Movie> getMoviesFromEntities(List<MovieEntity> movieEntities) {
		try{
			List<Movie> response = new ArrayList<Movie>();
			for(MovieEntity movieEntity : movieEntities){
				response.add(new Movie(movieEntity));					
			}
			return response;
		}
		catch(Exception e){
			return null;
		}
	}
}
