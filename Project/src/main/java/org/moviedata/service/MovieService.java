package org.moviedata.service;

import org.moviedata.entities.Movie;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface MovieService {

    int count();

    List <Movie> getAll();

    Optional<Movie> findMovie(int id);

    List<Movie> findAllMovies_ByDirectorID(int id);

    boolean deleteMovie(int id);

    float moviesAverageIncome_byDirectorID(int id);

    boolean addMovie(Movie newMovie);

    boolean changeMovieTakings(int id, int i);


    String movieWithHighestTakings();
}
