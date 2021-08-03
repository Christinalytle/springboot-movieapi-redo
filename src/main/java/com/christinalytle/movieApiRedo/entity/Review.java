package com.christinalytle.movieApiRedo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Review {
	private Long reviewId; 
	private String reviewText; 
	private Long starCount; //1 - 5 star review 
	
	@JsonIgnore
	private Movie movies;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getReviewId() {
		return reviewId;
	}
	public void setReviewId(Long reviewId) {
		this.reviewId = reviewId;
	}
	public String getReviewText() {
		return reviewText;
	}
	public void setReviewText(String reviewText) {
		this.reviewText = reviewText;
	}
	public Long getStarCount() {
		return starCount;
	}
	public void setStarCount(Long starCount) {
		this.starCount = starCount;
	}
	
	@ManyToOne
	@JoinColumn(name = "movieId")
	public Movie getMovies() {
		return movies;
	}
	public void setMovies(Movie movies) {
		this.movies = movies;
	} 
	

}