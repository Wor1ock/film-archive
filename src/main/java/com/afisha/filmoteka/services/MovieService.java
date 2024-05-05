package com.afisha.filmoteka.services;

import com.afisha.filmoteka.models.Movie;
import com.afisha.filmoteka.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    // Получить список всех фильмов
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    // Добавить новый фильм
    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }
}
