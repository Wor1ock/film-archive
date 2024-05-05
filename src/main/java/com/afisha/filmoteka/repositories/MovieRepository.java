package com.afisha.filmoteka.repositories;

import com.afisha.filmoteka.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
