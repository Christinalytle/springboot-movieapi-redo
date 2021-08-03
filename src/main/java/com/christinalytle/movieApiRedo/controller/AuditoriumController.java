package com.christinalytle.movieApiRedo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.christinalytle.movieApiRedo.entity.Auditorium;
import com.christinalytle.movieApiRedo.service.AuditoriumService;


@RestController
@RequestMapping("/auditoriums")
public class AuditoriumController {
	
	@Autowired
	private AuditoriumService service; 
	
	@RequestMapping (method = RequestMethod.GET) 
	public ResponseEntity<Object> getAuditoriums() {
		return new ResponseEntity<Object>(service.getAuditoriums(), HttpStatus.OK); 
	}
	
	@RequestMapping (method=RequestMethod.POST)
	public ResponseEntity<Object> createAuditorium(@RequestBody Auditorium auditorium) {
		return new ResponseEntity<Object>(service.createAuditorium(auditorium), HttpStatus.CREATED);
	}
	
	@RequestMapping (value="/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateAuditorium (@RequestBody Auditorium auditorium, @PathVariable Long id) {
		try {
			return new ResponseEntity<Object>(service.updateAuditorium(auditorium, id), HttpStatus.OK); 
		} catch (Exception e) {
			return new ResponseEntity<Object>("Unable to update auditoirum,", HttpStatus.BAD_REQUEST); 
		}
	}
	
	@RequestMapping (value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteAuditorium(@PathVariable Long id) {
		try {
			service.deleteAuditorium(id);
			return new ResponseEntity<Object>("Successfully deleted movie with id: " + id, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>("Unable to delete movie.", HttpStatus.BAD_REQUEST); 
		}
	}

}

