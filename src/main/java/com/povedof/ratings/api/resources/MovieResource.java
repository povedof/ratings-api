package com.povedof.ratings.api.resources;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.povedof.ratings.api.exceptionhandling.AppException;
import com.povedof.ratings.api.service.MovieService;
import javax.ws.rs.core.MediaType;

@Component
@Path("/movies")
public class MovieResource {

	@Autowired
	MovieService movieService;

	/**
	 * Returns all movies
	 */
	@GET
	@Path("/list")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Movie> getMovies() throws AppException {
		
		try{
		List<Movie> movies = movieService.getMovies();
		return movies;
		}
		catch(Exception e){
			throw e;
		}
	}
	
	/**
	 * Returns movie with mID
	 */
	@GET
	@Path("/{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Movie getMovie(@PathParam("id") int mID) throws AppException{
		
			try{
				return movieService.getMovie(mID);
			}
			catch(Exception e){
				throw e;
			}
	}

}