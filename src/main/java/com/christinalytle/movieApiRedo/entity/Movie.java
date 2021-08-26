package com.christinalytle.movieApiRedo.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Movie {
	
	private Long movieId; 
	private String title;
	private String synopsis; 
	private String posterUrl; 
	private Set<Review> reviews; 
	private Set<Screening> screenings; 
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getMovieId() {
		return movieId;
	}
	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	} 
	
	@OneToMany(mappedBy="movies")
	public Set<Screening> getScreenings() {
		return screenings; 
	}
	
	public void setScreenings(Set <Screening> screenings) {
		this.screenings = screenings; 
	}
	
	@OneToMany(mappedBy = "movies")
	public Set<Review> getReviews() {
		return reviews;
	}
	
	public void setReviews(Set<Review> reviews) {
		this.reviews = reviews;
	}
	
	public String getPosterUrl() {
		return posterUrl;
	}
	
	public void setPosterUrl(String posterUrl) {
		this.posterUrl = posterUrl;
	}
	public String getSynopsis() {
		return synopsis;
	}
	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}
	
	

}
