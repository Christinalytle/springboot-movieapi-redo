package com.christinalytle.movieApiRedo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.christinalytle.movieApiRedo.entity.Screening;
import com.christinalytle.movieApiRedo.entity.ScreeningDto;
import com.christinalytle.movieApiRedo.service.ScreeningService;




@CrossOrigin
@RestController
@RequestMapping("/movies/{movieId}/screenings")
public class ScreeningController {
	
	@Autowired
	private ScreeningService service; 
	


//	@RequestMapping (method=RequestMethod.GET)
//	public ResponseEntity<Object> geScreenings() {
//		return new ResponseEntity<Object>(service.getScreenings(), HttpStatus.OK); 
//		}
	
	@PostMapping
	public ResponseEntity<Object> createScreening(@RequestBody Screening screening, @PathVariable Long movieId) {
		return new ResponseEntity<Object>(service.createScreening(screening, movieId), HttpStatus.CREATED); 
	}
	
	@RequestMapping(value = "/{screeningId}",  method=RequestMethod.PUT)
	public ResponseEntity<Object> updateScreening(@RequestBody ScreeningDto screeningDto, @PathVariable Long screeningId, @PathVariable Long movieId) {
	try {
		return new ResponseEntity<Object>(service.updateScreening(screeningId, movieId, screeningDto.getAuditorium(), screeningDto.getTime()), HttpStatus.OK);
	} catch (Exception e) {
		return new ResponseEntity<Object>("Unable to update screening.", HttpStatus.BAD_REQUEST); 
	}
	}

	@RequestMapping(value="/{screeningId}", method=RequestMethod.DELETE)
	public ResponseEntity<Object> deleteScreening (@PathVariable Long screeningId) {
	try {
		service.deleteScreening(screeningId);
		return new ResponseEntity<Object>("Successfully deleted screening with id: " + screeningId, HttpStatus.OK); 
	} catch (Exception e) {
		return new ResponseEntity<Object>("Unable to delete screening", HttpStatus.BAD_REQUEST); 
	}
}

}
