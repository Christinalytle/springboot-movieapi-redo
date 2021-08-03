package com.christinalytle.movieApiRedo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@Entity
public class Screening {
	private Long screeningId;
	private Movie movies; 
	private Auditorium auditoriums; 
	private String time;
	
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
	
	@ManyToOne
	@JoinColumn(name = "auditoriumId")
	public Auditorium getAuditorium() {
		return auditoriums;
	}
	
	public void setAuditorium(Auditorium auditoriums) {
		this.auditoriums = auditoriums;
	}
	
	public String getTime() {
		return time;
	}
	
	public void setTime(String time) {
		this.time = time;
	} 
	
	

}
