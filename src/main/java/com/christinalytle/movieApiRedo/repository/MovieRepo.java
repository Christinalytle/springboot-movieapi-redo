package com.christinalytle.movieApiRedo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.christinalytle.movieApiRedo.entity.Movie;

public interface MovieRepo extends JpaRepository <Movie, Long> {

}
