import org.moviedata.entities.Director;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.moviedata.repo.DirectorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;


@ExtendWith(SpringExtension.class)        // Adds SpringExtension i.e. Spring stuff to Junit5
@ContextConfiguration(locations = {"classpath:/beans.xml"})
public class TestDirectorRepo {

    @Autowired
    private DirectorRepo directorRepo;

    @Test
    public void deleteDirector(){
        Assertions.assertAll(
                () -> Assertions.assertEquals(1, directorRepo.deleteDirector(2)),
                () -> Assertions.assertEquals(0, directorRepo.deleteDirector(200))
        );
    }

    @Test
    public void addDirector(){
        Assertions.assertAll(
                () -> Assertions.assertEquals(1, directorRepo.createDirector(new Director(100, "FIRST_NAME222", "LAST_NAME2222", 1))),
                () -> Assertions.assertThrows(DataIntegrityViolationException.class, () -> directorRepo.createDirector(new Director(1, "FIRST_NAME222", "LAST_NAME2222", 1)))
        );
    }

    @Test
    public void changeDirectorStatus(){
        Assertions.assertAll(
                () -> Assertions.assertNotNull(directorRepo.changeDirectorStatus(2,0))
        );

    }

    @Test
    public void numberOfInactiveDirectors(){
        Assertions.assertAll(
                () -> Assertions.assertNotNull(directorRepo.getNumberOfInactiveDirectors())
        );
    }


}


