import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.moviedata.entities.Director;
import org.moviedata.entities.Movie;
import org.moviedata.repo.DirectorRepo;
import org.moviedata.repo.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)        // Adds SpringExtension i.e. Spring stuff to Junit5
@ContextConfiguration(locations = {"classpath:/beans.xml"})
public class TestMovieRepo {

    @Autowired
    private MovieRepo movieRepo;

    @Test
    public void deleteMovie(){
        Assertions.assertAll(
                () -> Assertions.assertEquals(1, movieRepo.deleteMovie(2)),
                () -> Assertions.assertEquals(0, movieRepo.deleteMovie(200))
        );
    }

    @Test
    public void addMovie(){
        Assertions.assertAll(
                () -> Assertions.assertEquals(1, movieRepo.createMovie(new Movie(80, "FIRST_NAME222_222", 1997, 1000000, 5))),
                () -> Assertions.assertThrows(DataIntegrityViolationException.class, () -> movieRepo.createMovie(new Movie(3, "FIRST_NAME222_222", 1997, 1000000, 5)))
        );
    }

    @Test
    public void changeMovieTakings(){
        Assertions.assertAll(
                () -> Assertions.assertNotNull(movieRepo.modifyMovieTakings(2,100))
        );
    }

    @Test
    public void movieWithHighestTakings(){
        Assertions.assertAll(
                () -> Assertions.assertNotNull(movieRepo.movieWithHighestTakings())
        );
    }

    @Test
    public void averageIncome_byDirectorID(){
        Assertions.assertAll(
                () -> Assertions.assertNotNull(movieRepo.moviesAverageIncome_byDirectorID(6)));
    }

}


