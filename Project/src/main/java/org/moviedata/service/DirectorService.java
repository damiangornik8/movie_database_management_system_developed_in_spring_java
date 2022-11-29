package org.moviedata.service;

import org.moviedata.entities.Director;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface DirectorService {

    int count();

    List<Director> getAll();

    int getNumberOfInactiveDirectors();


    Optional<Director> findDirector(int id);

    boolean deleteDirector(int id);

    boolean addDirector(Director newDirector);

    boolean changeDirectorStatus(int id, int i);


}
