package com.christinalytle.movieApiRedo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class Screening {
	private Long screeningId;
	private Long auditorium; 
	private String time;
	
	@JsonIgnore
	private Movie movies; 
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getScreeningId() {
		return screeningId;
	}
	
	
	public void setScreeningId(Long screeningId) {
		this.screeningId = screeningId;
	}
	
	@ManyToOne
	@JoinColumn(name = "movieId")
	public Movie getMovies() {
		return movies;
	}
	
	public void setMovies(Movie movies) {
		this.movies = movies;
	}
	
	public Long getAuditorium() {
		return auditorium;
	}
	
	public void setAuditorium(Long auditorium) {
		this.auditorium = auditorium;
	}
	
	public String getTime() {
		return time;
	}
	
	public void setTime(String time) {
		this.time = time;
	} 
	
	

}
