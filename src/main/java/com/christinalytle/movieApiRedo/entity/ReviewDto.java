package com.christinalytle.movieApiRedo.entity;

public class ReviewDto {
	
	private Long reviewId; 
	private Long movieId; 
	private String reviewText; 
	private Long starCount;
	
	public Long getReviewId() {
		return reviewId;
	}
	public void setReviewId(Long reviewId) {
		this.reviewId = reviewId;
	}
	public Long getMovieId() {
		return movieId;
	}
	public void setMovieId(Long movieId) {
		this.movieId = movieId;
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
	

}
