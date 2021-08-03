package com.christinalytle.movieApiRedo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.christinalytle.movieApiRedo.entity.Review;

public interface ReviewRepo extends JpaRepository <Review, Long> {

}
