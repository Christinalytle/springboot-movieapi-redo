package com.christinalytle.movieApiRedo.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.christinalytle.movieApiRedo.entity.Auditorium;
import com.christinalytle.movieApiRedo.entity.Movie;
import com.christinalytle.movieApiRedo.entity.Screening;
import com.christinalytle.movieApiRedo.repository.AuditoriumRepo;
import com.christinalytle.movieApiRedo.repository.MovieRepo;
import com.christinalytle.movieApiRedo.repository.ScreeningRepo;



@Service
public class ScreeningService {
	
	private static final Logger Logger = LogManager.getLogger(ScreeningService.class);
	
	@Autowired
	private ScreeningRepo repo; 
	
	@Autowired
	private AuditoriumRepo audRepo; 
	
	@Autowired
	private MovieRepo movieRepo; 
	
	//GET by Id
	public Screening getScreeningById (Long id) throws Exception {
		try {
			return repo.findById(id).orElseThrow(); 
			
		} catch (Exception e) {
			Logger.error("Exception occured while trying to get Screenings", e);
			throw e;
		}
	}
	
	//GET all
	public Iterable<Screening> getScreenings() {
		return repo.findAll(); 
	}
	
	//POST
	public Screening createScreening (Long auditoriumId, Long movieId, String time) {
		Screening screening = new Screening(); 
		Auditorium aud = audRepo.findById(auditoriumId).orElseThrow(); 
		Movie mov = movieRepo.findById(movieId).orElseThrow(); 
		screening.setAuditorium(aud);
		screening.setMovies(mov);
		screening.setTime(time);
		return repo.save(screening); 
	}
	
	//Update
	public Screening updateScreening(Long screeningId, Long auditoriumId, Long movieId, String time ) throws Exception {
		try {
			Screening oldScreening = repo.findById(screeningId).orElseThrow(); 
			Auditorium aud = audRepo.findById(auditoriumId).orElseThrow(); 
			Movie mov = movieRepo.findById(movieId).orElseThrow(); 
			oldScreening.setAuditorium(aud);
			oldScreening.setMovies(mov);
			oldScreening.setTime(time);
			return repo.save(oldScreening);
		} catch (Exception e) {
			Logger.error("Error occured while trying to update this screening", e);
			throw new Exception("Unable to update screening.");
		}
	}
	
	//Delete 
	public void deleteScreening (Long id) throws Exception {
		try  {
			repo.deleteById(id);
		} catch (Exception e) {
			Logger.error("Error occured while trying to delete screening " + id, e);
			throw new Exception ("Unable to delete screening.");
		}
	}
	
	

}