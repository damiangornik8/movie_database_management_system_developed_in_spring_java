package org.moviedata.repo;

import org.moviedata.entities.Director;

import java.util.List;

public interface DirectorRepo {
    int count();

    List<Director> getAll();

    int getNumberOfInactiveDirectors();

    Director findDirector(int id);

    boolean exists(int id);


    int deleteDirector(int id);

    int createDirector(Director newDirector);

    int changeDirectorStatus(int id, int make_active_or_inactive);
}
