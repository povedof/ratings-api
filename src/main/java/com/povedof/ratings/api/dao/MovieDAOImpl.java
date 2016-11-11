package com.povedof.ratings.api.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.povedof.ratings.api.entity.MovieEntity;

@Repository
public class MovieDAOImpl implements MovieDAO {

	//need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory; 
	
	@Override
	public List<MovieEntity> getMovies() {
		
		try{
			//get the current hibernate session
			Session currentSession = sessionFactory.getCurrentSession();
			
			//create query ... sort by last name
			Query<MovieEntity> query = currentSession.createQuery("from MovieEntity order by title",MovieEntity.class);
			
			//execute query and get result list
			List<MovieEntity> movieEntities = query.getResultList();
			
			//System.out.println(movies.toString());
			
			//return the results
			
			return movieEntities;
		}
		catch(Exception e){
			return null;
		}
		
	}

	@Override
	public MovieEntity getMovie(int mID) {
		
		try{
			//get the current hibernate session
			Session currentSession = sessionFactory.getCurrentSession();
					
			//retrieve/read from d.b. using primary key
			MovieEntity movieEntity = currentSession.get(MovieEntity.class,mID);
			
			return movieEntity;
		}
		catch(Exception e){
			return null;
		}
		
	}
	
}
