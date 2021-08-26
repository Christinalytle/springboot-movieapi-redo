package com.christinalytle.movieApiRedo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.christinalytle.movieApiRedo.entity.Movie;
import com.christinalytle.movieApiRedo.service.MovieService;


@CrossOrigin
@RestController
@RequestMapping("/movies")
public class MovieController {
	
	@Autowired
	private MovieService service; 
	
	@RequestMapping (method = RequestMethod.GET)
	public ResponseEntity<Object> getMovies() {
		return new ResponseEntity<Object>(service.getMovies(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method=RequestMethod.GET)
	public ResponseEntity<Object> getMovie(@PathVariable Long id) throws Exception {
		return new ResponseEntity<Object>(service.getMovieById(id), HttpStatus.OK);
	}
	
	@RequestMapping (method = RequestMethod.POST)
	public ResponseEntity<Object> createMovie(@RequestBody Movie movie) {
		return new ResponseEntity<Object>(service.createMovie(movie), HttpStatus.CREATED); 
	}
	
	@RequestMapping(value = "/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Object> updateMovie(@RequestBody Movie movie, @PathVariable Long id) {
		try {
			return new ResponseEntity<Object>(service.updateMovie(movie, id), HttpStatus.OK); 
		} catch (Exception e) {
			return new ResponseEntity<Object>("Unable to update movie", HttpStatus.BAD_REQUEST); 
		}
	}
	
	@RequestMapping(value="{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Object> deleteMovie (@PathVariable Long id) {
		try {
			service.deleteMovie(id);
			return new  ResponseEntity<Object>("Successfully deleted movie with id " + id, HttpStatus.OK); 
		} catch (Exception e) {
			return new  ResponseEntity<Object>("Unable to delete movie", HttpStatus.BAD_REQUEST); 
		}
	}

}
