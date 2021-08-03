package com.christinalytle.movieApiRedo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.christinalytle.movieApiRedo.entity.ScreeningDto;
import com.christinalytle.movieApiRedo.service.ScreeningService;




@RestController
@RequestMapping("/screenings")
public class ScreeningController {
	
	@Autowired
	private ScreeningService service; 
	


	@RequestMapping (method=RequestMethod.GET)
	public ResponseEntity<Object> geScreenings() {
		return new ResponseEntity<Object>(service.getScreenings(), HttpStatus.OK); 
		}
	
	@RequestMapping (method = RequestMethod.POST)
	public ResponseEntity<Object> createScreening(@RequestBody ScreeningDto screeningDto) {
		return new ResponseEntity<Object>(service.createScreening(screeningDto.getAuditoriumId(), screeningDto.getMovieId(), screeningDto.getTime()), HttpStatus.CREATED); 
	}
	
	@RequestMapping(value = "/{id}",  method=RequestMethod.PUT)
	public ResponseEntity<Object> updateScreening(@RequestBody ScreeningDto screeningDto, @PathVariable Long id) {
	try {
		return new ResponseEntity<Object>(service.updateScreening(id, screeningDto.getAuditoriumId(), screeningDto.getMovieId(), screeningDto.getTime()), HttpStatus.OK);
	} catch (Exception e) {
		return new ResponseEntity<Object>("Unable to update screening.", HttpStatus.BAD_REQUEST); 
	}
	}

	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Object> deleteScreening (@PathVariable Long id) {
	try {
		service.deleteScreening(id);
		return new ResponseEntity<Object>("Successfully deleted screening with id: " + id, HttpStatus.OK); 
	} catch (Exception e) {
		return new ResponseEntity<Object>("Unable to delete screening", HttpStatus.BAD_REQUEST); 
	}
}

}
