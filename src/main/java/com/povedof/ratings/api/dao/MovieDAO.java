package com.povedof.ratings.api.dao;

import java.util.List;
import com.povedof.ratings.api.entity.MovieEntity;

public interface MovieDAO {
	
	public List<MovieEntity> getMovies();
	
	public MovieEntity getMovie(int mID);
	
}
