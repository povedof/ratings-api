package com.povedof.ratings.api.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.povedof.ratings.api.entity.MovieEntity;

public interface MovieDAO {
	
	public List<MovieEntity> getMovies() throws DataAccessException;
	
	public MovieEntity getMovie(int mID) throws DataAccessException;
	
}
