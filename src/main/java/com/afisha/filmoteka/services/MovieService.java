package com.afisha.filmoteka.services;

import com.afisha.filmoteka.models.Director;
import com.afisha.filmoteka.models.Movie;
import com.afisha.filmoteka.repositories.MovieRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    // Получить список всех фильмов
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    // Получить информацию о конкретном фильме по его идентификатору
    public Movie getMovieById(Long id) {
        Optional<Movie> movie = movieRepository.findById(id);
        return movie.orElse(null);
//                .orElseThrow(() -> new RuntimeException("Movie not found with id: " + id));
    }

    // Добавить новый фильм
    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    // Удалить фильм по его идентификатору
    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }

    // Обновить фильм по его идентификатору
    public Movie updateMovie(Long id, Movie updatedMovieData) {
        Movie existingMovie = movieRepository.findById(id).orElse(null);
        log.info("Existing movie: {}", existingMovie);
        if (existingMovie != null) {
            existingMovie.setTitle(updatedMovieData.getTitle());
            existingMovie.setReleaseYear(updatedMovieData.getReleaseYear());
            existingMovie.setWorldwideGross(updatedMovieData.getWorldwideGross());
            existingMovie.setDuration(updatedMovieData.getDuration());
            existingMovie.setDirector(updatedMovieData.getDirector());
            existingMovie.setActors(updatedMovieData.getActors());
            return movieRepository.save(existingMovie);
        } else {
            log.warn("Movie not found with id: {}", id);
            return null;
        }
    }
}

