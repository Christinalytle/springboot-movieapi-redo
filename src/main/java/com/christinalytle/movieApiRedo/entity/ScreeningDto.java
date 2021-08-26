package com.christinalytle.movieApiRedo.entity;

public class ScreeningDto {
	
	private Long movieId; 
	private Long auditorium;
	private String time;
	  
	
	//The DTO is used to input variables in PostMan so they can connect to the right object 
	
	public Long getAuditorium() {
		return auditorium;
	}
	public void setAuditorium(Long auditorium) {
		this.auditorium = auditorium;
	}
	
	
	public Long getMovieId() {
		return movieId;
	}
	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}
	
	
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}

}