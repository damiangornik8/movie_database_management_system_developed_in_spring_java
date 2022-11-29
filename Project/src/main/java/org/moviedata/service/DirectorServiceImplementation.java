package org.moviedata.service;

import lombok.extern.slf4j.Slf4j;
import org.moviedata.entities.Director;
import org.moviedata.repo.DirectorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class DirectorServiceImplementation implements DirectorService {

    @Autowired
    DirectorRepo directorRepo;

    @Override
    public int count() {
        return 0;
    }

    @Override
    public List<Director> getAll() {
        return directorRepo.getAll();
    }

    @Override
    public int getNumberOfInactiveDirectors() {
        return directorRepo.getNumberOfInactiveDirectors();
    }




    @Override
    public Optional<Director> findDirector(int id) {

        if (directorRepo.exists(id)) {
            return Optional.of(directorRepo.findDirector(id));
        }

        return Optional.empty();
    }

    @Override
    public boolean deleteDirector(int id) {
        if (directorRepo.exists(id)) {
            return directorRepo.deleteDirector(id)==1;
        }
//        log.err("Not deleted - error");
        return false;
    }



    @Override
    public boolean addDirector(Director newDirector) {
//        if (directorRepo.exists(newDirector.getFirstName())) {
////            log.error(newDirector.getDirectorName());
//            return false;
//        }


        if (directorRepo.exists(newDirector.getDirectorId())) {
//            log.error(newDirector.getDirectorId());
            return false;
        }

        return directorRepo.createDirector(newDirector) == 1;
    }

    @Override
    public boolean changeDirectorStatus(int id, int make_active_or_inactive) {




        return directorRepo.changeDirectorStatus(id, make_active_or_inactive) == 1;
    }
}
