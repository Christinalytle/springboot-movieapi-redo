package com.christinalytle.movieApiRedo.entity;

public class ScreeningDto {
	
	private Long movieId; 
	private Long auditoriumId;
	private String time;
	  
	
	//The DTO is used to input variables in PostMan so they can connect to the right object 
	
	public Long getAuditoriumId() {
		return auditoriumId;
	}
	public void setAuditoriumId(Long auditoriumId) {
		this.auditoriumId = auditoriumId;
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