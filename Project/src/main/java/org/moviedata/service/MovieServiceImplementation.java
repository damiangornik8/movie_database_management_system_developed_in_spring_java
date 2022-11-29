package org.moviedata.service;

import lombok.extern.slf4j.Slf4j;
import org.moviedata.entities.Movie;
import org.moviedata.repo.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class MovieServiceImplementation implements MovieService {

    @Autowired
    MovieRepo movieRepo;

    @Override
    public int count() {
        return 0;
    }

    @Override
    public List<Movie> getAll() {
        return movieRepo.getAll();
    }

    @Override
    public Optional<Movie> findMovie(int id) {

        if (movieRepo.exists(id)) {
            return Optional.of(movieRepo.findMovie_ByID(id));
        }

        return Optional.empty();
    }

    @Override
    public List<Movie> findAllMovies_ByDirectorID(int id) {

//        if (movieRepo.exists(id)) {
//            return Optional.of(movieRepo.findAllMovies_ByDirectorID(id));
//        }

        return (movieRepo.findAllMovies_ByDirectorID(id));
    }


    @Override
    public boolean deleteMovie(int id) {
        if (movieRepo.exists(id)) {
            return movieRepo.deleteMovie(id)==1;
        }
//        log.err("Not deleted - error");
        return false;
    }
    @Override
    public float moviesAverageIncome_byDirectorID(int id) {
        return movieRepo.moviesAverageIncome_byDirectorID(id);
    }


    @Override
    public boolean addMovie(Movie newMovie) {



        if (movieRepo.exists(newMovie.getMovieID())) {
//            log.error(newDirector.getDirectorId());
            return false;
        }

        return movieRepo.createMovie(newMovie) == 1;
    }



    @Override
    public boolean changeMovieTakings(int id, int new_movie_takings) {




        return movieRepo.modifyMovieTakings(id, new_movie_takings) == 1;
    }

    @Override
    public String movieWithHighestTakings() {
        return movieRepo.movieWithHighestTakings();
    }
}
