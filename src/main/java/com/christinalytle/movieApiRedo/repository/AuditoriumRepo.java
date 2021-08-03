package com.christinalytle.movieApiRedo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.christinalytle.movieApiRedo.entity.Auditorium;

public interface AuditoriumRepo extends JpaRepository <Auditorium, Long> {

}
