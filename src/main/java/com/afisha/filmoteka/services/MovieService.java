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

    // Получить информацию о конкретном фильме по его идентификатору
    public Movie getMovieById(Long id) {
        return movieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Movie not found with id: " + id));
    }

    // Добавить новый фильм
    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    // Удалить фильм по его идентификатору
    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }
}

