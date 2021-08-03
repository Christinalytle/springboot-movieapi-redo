package com.christinalytle.movieApiRedo.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.christinalytle.movieApiRedo.entity.Movie;
import com.christinalytle.movieApiRedo.entity.Review;
import com.christinalytle.movieApiRedo.repository.MovieRepo;
import com.christinalytle.movieApiRedo.repository.ReviewRepo;





@Service
public class ReviewService {
	
	private static final Logger Logger = LogManager.getLogger(ReviewService.class); 
	
	@Autowired
	private ReviewRepo repo; 
	
	@Autowired
	private MovieRepo movieRepo; 
	
	//GET by Id
	public Review getReviewById (Long id) throws Exception {
		try {
			return repo.findById(id).orElseThrow(); 
		} catch (Exception e) {
			Logger.error("Error occured while trying to get review "+ id, e); 
			throw e; 
		}
	}
	
	//GET all reviews 
	public Iterable<Review> getReviews() {
		return repo.findAll(); 
	}
	
	//POST a review
	public Review createReview (Review review, Long movieId) {
		Movie mov = movieRepo.findById(movieId).orElseThrow();
		review.setMovies(mov);
		return repo.save(review);  

	}
	
	//Update
	public Review updateReview (Long reviewId, Long movieId, String reviewText, Long starCount) throws Exception {
		try {
			Review oldReview = repo.findById(reviewId).orElseThrow(); 
			Movie mov = movieRepo.findById(movieId).orElseThrow(); 
			oldReview.setMovies(mov);
			oldReview.setReviewText(reviewText);
			oldReview.setStarCount(starCount);
			return repo.save(oldReview); 
		} catch (Exception e) {
			Logger.error("An error occured while trying to update this review",e); 
			throw new Exception("Unable to update screening"); 
		}
		
	}
	
	//Delete
	public void deleteReview (Long id) throws Exception {
		try {
			repo.deleteById(id);
		} catch (Exception e) {
			Logger.error("Error occured while trying to delete review " + id, e);
			throw new Exception ("Unable to delete review.");
		}
	}

}
