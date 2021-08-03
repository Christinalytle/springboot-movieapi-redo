package com.christinalytle.movieApiRedo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.christinalytle.movieApiRedo.entity.Screening;

public interface ScreeningRepo extends JpaRepository <Screening, Long> {

}
