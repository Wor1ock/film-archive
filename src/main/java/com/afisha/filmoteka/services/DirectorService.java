package com.afisha.filmoteka.services;

import com.afisha.filmoteka.models.Director;
import com.afisha.filmoteka.repositories.DirectorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DirectorService {

    @Autowired
    private final DirectorRepository directorRepository;

    public List<Director> getAllDirectors() {
        return directorRepository.findAll();
    }

    public Optional<Director> getDirectorById(Long id) {
        return directorRepository.findById(id);
    }

    public void deleteDirectorById(Long id) {
        directorRepository.deleteById(id);
    }
}

