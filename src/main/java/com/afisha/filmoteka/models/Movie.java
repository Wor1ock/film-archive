package com.afisha.filmoteka.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movieId;

    private String title;
    private int releaseYear;
    private double worldwideGross;
    private int duration;

    @ManyToOne
    @JoinColumn(name = "director_id")
    private Director director;

    @ManyToMany
    @JoinTable(
            name = "MovieActors",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id"))
    private List<Actor> actors;

}