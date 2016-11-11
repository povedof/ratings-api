package com.povedof.ratings.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="movie")
public class MovieEntity {
	
	@Id
	@Column(name="mID")
	private int mID;
	
	@Column(name="title")
	private String title;
	
	@Column(name="year")
	private int year;
	
	@Column(name="director")
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

	@Override
	public String toString() {
		return "Movie [mID=" + mID + ", title=" + title + ", year=" + year + ", director=" + director + "]";
	}
	
}
