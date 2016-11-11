package com.povedof.ratings.api.resources;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import org.apache.commons.beanutils.BeanUtils;
import com.povedof.ratings.api.entity.MovieEntity;

@XmlRootElement
public class Movie implements Serializable {

	private static final long serialVersionUID = -8039686696076337053L;

	/** id of the movie */
	private int mID;

	/** title of the movie */
	private String title;

	/** year of the movie */
	private int year;

	/** director of the movie */
	private String director;

	public int getmID() {
		return mID;
	}

	public void setmID(int mID) {
		this.mID = mID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}
	
	public Movie (MovieEntity movieEntity){
		try {
			BeanUtils.copyProperties(this, movieEntity);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Movie(int mID, String title, int year, String director) {
		this.mID = mID;
		this.title = title;
		this.year = year;
		this.director = director;

	}

	public Movie() {
	}

}

