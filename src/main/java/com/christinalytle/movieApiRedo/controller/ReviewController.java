package com.christinalytle.movieApiRedo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.christinalytle.movieApiRedo.entity.Review;
import com.christinalytle.movieApiRedo.service.ReviewService;



@RestController 
@RequestMapping("/movies/{movieId}/reviews")
public class ReviewController {

	@Autowired
	private ReviewService service;
	
	
	@PostMapping
	public ResponseEntity<Object> createReview (@RequestBody Review review, @PathVariable Long movieId) {
		try {
			return new ResponseEntity<Object>(service.createReview(review, movieId), HttpStatus.OK); 
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST); 
		}
	}
	
	@RequestMapping(value="/{reviewId}", method = RequestMethod.DELETE)
		public ResponseEntity<Object> deleteReview (@PathVariable Long reviewId) throws Exception {
			service.deleteReview(reviewId);
			return new ResponseEntity<Object>("Deleted review", HttpStatus.OK); 
		}

	
	
}
