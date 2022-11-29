package org.moviedata.repo;

import org.moviedata.entities.Director;
import org.moviedata.entities.Movie;

import java.util.List;

public interface MovieRepo {
    int count();
    
    List<Movie> getAll();

    Movie findMovie_ByID(int id);


    List<Movie> findAllMovies_ByDirectorID(int id);

    boolean exists(int id);


    int deleteMovie(int id);

    int createMovie(Movie newMovie);

    float moviesAverageIncome_byDirectorID(int id);

    String movieWithHighestTakings();



    int modifyMovieTakings (int id, int newTakings);


}
