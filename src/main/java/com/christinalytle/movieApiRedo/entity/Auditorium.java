package com.christinalytle.movieApiRedo.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;



import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity 
public class Auditorium {
	
	private Long auditoriumId; 
	private Long auditoriumNumber; 
	
	@JsonIgnore
	private Set<Screening> screenings; 
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	public Long getAuditoriumId() {
		return auditoriumId; 
	}

	public void setAuditoriumId(Long auditoriumId) {
		this.auditoriumId = auditoriumId; 
	}
	
	public Long getAuditoriumNumber() {
		return auditoriumNumber;
	}

	public void setAuditoriumNumber(Long auditoriumNumber) {
		this.auditoriumNumber = auditoriumNumber;
	}
	
	@OneToMany (mappedBy = "auditorium")
	public Set<Screening> getScreenings() {
		return screenings; 
	}
	
	public void setScreenings(Set<Screening> screenings) {
		this.screenings = screenings; 
	}
	

}
