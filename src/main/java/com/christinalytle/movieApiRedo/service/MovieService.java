package com.christinalytle.movieApiRedo.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.christinalytle.movieApiRedo.entity.Movie;
import com.christinalytle.movieApiRedo.repository.MovieRepo;





@Service
public class MovieService {

	private static final Logger Logger = LogManager.getLogger(MovieService.class);
	
	@Autowired
	private MovieRepo repo; 
	
	//Get a movie by its id
	public Movie getMovieById (Long id) throws Exception {
		try {
			return repo.findById(id).orElseThrow(); 
		} catch (Exception e) {
			Logger.error("Error occured while trying to find movie " +id, e);
			throw e; 
		}
	}
	
	//Post a movie
	public Movie createMovie (Movie movie) {
		return repo.save(movie); 
	}
	
	//Get all movies
	public Iterable<Movie> getMovies() {
		return repo.findAll(); 
	}
	
	//Update a movie by its id
	public Movie updateMovie (Movie movie, Long id) throws Exception {
		try {
			Movie oldMovie = repo.findById(id).orElseThrow(); 
			oldMovie.setTitle(movie.getTitle());
			oldMovie.setSynopsis(movie.getSynopsis());
			oldMovie.setPosterUrl(movie.getPosterUrl());
			return repo.save(oldMovie); 
		} catch (Exception e) {
			Logger.error("Error occured while trying to update movie " + id, e);
			throw new Exception ("Unable to update movie");
		}
	}
	
	//Delete
	public void deleteMovie(Long id) throws Exception {
		try {
			repo.deleteById(id);
		} catch (Exception e) {
			Logger.error("Error occured while trying to delete movie "+id, e);
			throw new Exception("Unable to delete movie.");
		}
	}
	
}

