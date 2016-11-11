package com.povedof.ratings.api.resources;

import java.io.IOException;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.povedof.ratings.api.service.MovieService;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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
	public List<Movie> getMovies() throws IOException{
		List<Movie> movies = movieService.getMovies();
		return movies;
	}
	
	/**
	 * Returns movie with mID
	 */
	@GET
	@Path("/{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response getMovie(@PathParam("id") int mID) throws IOException{
		Movie movie = movieService.getMovie(mID);
		if(movie!=null){
			return Response.status(200).entity(movie).build();
		}
		else{
			return Response.status(404).entity("The movie with id " + mID + " does not exist").build();
		}
	}

}