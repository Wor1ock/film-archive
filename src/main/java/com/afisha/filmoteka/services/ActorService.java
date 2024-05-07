package com.afisha.filmoteka.services;

import com.afisha.filmoteka.models.Actor;
import com.afisha.filmoteka.repositories.ActorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ActorService {

    @Autowired
    private final ActorRepository actorRepository;

    public List<Actor> getAllActors() {
        return actorRepository.findAll();
    }

    public void deleteActor(Long id) {
        actorRepository.deleteById(id);
    }
}
