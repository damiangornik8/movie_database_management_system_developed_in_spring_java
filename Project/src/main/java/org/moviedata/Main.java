package org.moviedata;

import org.moviedata.entities.Director;
import org.moviedata.entities.Movie;
import org.moviedata.service.DirectorService;
import org.moviedata.service.DirectorServiceImplementation;
import org.moviedata.service.MovieService;
import org.moviedata.service.MovieServiceImplementation;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Locale;


public class Main {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context3 = new ClassPathXmlApplicationContext("beans.xml");

        DirectorService directorService = context3.getBean(DirectorServiceImplementation.class);

        System.out.println();
        System.out.println("-----------");
        System.out.println();

        System.out.println("All directors before adding new directors:");

        System.out.println(context3.getMessage("add_new_director_before", null, Locale.ITALIAN));
        System.out.println(context3.getMessage("add_new_director_before", null, Locale.FRENCH));
        System.out.println(context3.getMessage("add_new_director_before", null, Locale.getDefault()));

        System.out.println(" ");
        directorService.getAll().forEach(System.out::println);
        System.out.println();

        //  #   #   #   #   #
        //  #
        //  #
        //  #   Add Director
        //  #
        //  #
        //  #   #   #   #   #


        // Add Director
        System.out.println("Add director (already exists): " + directorService.addDirector(new Director(1, "FIRST_NAME222_222", "LAST_NAME222_222", 1)));
        System.out.println("Add director all ok:" + directorService.addDirector(new Director(6, "FIRST_NAME222", "LAST_NAME2222", 1)));

        System.out.println();
        System.out.println("All directors after adding new directors: ");
        directorService.getAll().forEach(System.out::println);

        System.out.println();
        System.out.println("-----------");
        System.out.println();

        //  #   #   #   #   #
        //  #
        //  #
        //  #   Change Director Status
        //  #
        //  #
        //  #   #   #   #   #

        System.out.println("Director status before changing it: ");
        directorService.findDirector(6).ifPresentOrElse(System.out::println, () -> System.out.println("Director not found..."));

        // Change Director Status (1 - Make it active // 0 - Make it inactive)
        System.out.println("Change director status:" + directorService.changeDirectorStatus(6, 0));

        System.out.println();
        System.out.println("Director status after changing it: ");
        directorService.findDirector(6).ifPresentOrElse(System.out::println, () -> System.out.println("Director not found..."));

        System.out.println();
        System.out.println("-----------");
        System.out.println();

        //  #   #   #   #   #
        //  #
        //  #
        //  #   Delete Director
        //  #
        //  #
        //  #   #   #   #   #

        System.out.println("All directors before deleting director: ");
        directorService.getAll().forEach(System.out::println);
        System.out.println();

        // Delete Director by Id
        System.out.println("Delete director exists:" + directorService.deleteDirector(1));

        System.out.println("All directors after deleting director: ");
        directorService.getAll().forEach(System.out::println);
        System.out.println();

        System.out.println();
        System.out.println("-----------");
        System.out.println();

        //  #   #   #   #   #
        //  #
        //  #
        //  #   Find Director by ID
        //  #
        //  #
        //  #   #   #   #   #

        // Find director by id
        System.out.println("Find director by id: ");
        directorService.findDirector(6).ifPresentOrElse(System.out::println, () -> System.out.println("Director not found..."));

        //  #   #   #   #   #
        //  #
        //  #
        //  #   Number of Inactive Directors
        //  #
        //  #
        //  #   #   #   #   #

        // Number of inactive directors:
        System.out.println("Number of inactive directors: ");
        System.out.println(directorService.getNumberOfInactiveDirectors());

        System.out.println();
        System.out.println("-----------");
        System.out.println("-----------");
        System.out.println("-----------");
        System.out.println();

        //  #   #   #   #   #
        //  #
        //  #
        //  #   Modify Movie Takings
        //  #
        //  #
        //  #   #   #   #   #

        MovieService movieService = context3.getBean(MovieServiceImplementation.class);

        System.out.println("Movie before changing takings: ");
        movieService.findMovie(2).ifPresentOrElse(System.out::println, () -> System.out.println("Movie not found..."));
        System.out.println();

        // Change Movie Takings
        System.out.println("Change Movie Takings: ");
        System.out.println(movieService.changeMovieTakings(2, 1));

        System.out.println("Movie after changing takings: ");
        movieService.findMovie(2).ifPresentOrElse(System.out::println, () -> System.out.println("Movie not found..."));
        System.out.println();

        System.out.println();
        System.out.println("-----------");
        System.out.println();

        //  #   #   #   #   #
        //  #
        //  #
        //  #   Delete Movie by ID
        //  #
        //  #
        //  #   #   #   #   #

        System.out.println("All Movies before deleting: ");
        movieService.getAll().forEach(System.out::println);
        System.out.println();

        System.out.println("Delete movie by ID: ");
        System.out.println("Delete movie if exists:" + movieService.deleteMovie(1));
        System.out.println("Delete movie if does not exists:" + movieService.deleteMovie(20));

        System.out.println();
        System.out.println("All Movies after deleting: ");
        movieService.getAll().forEach(System.out::println);
        System.out.println();

        System.out.println();
        System.out.println("-----------");
        System.out.println();


        //  #   #   #   #   #
        //  #
        //  #
        //  #   Average movie takings Director by ID
        //  #
        //  #
        //  #   #   #   #   #

        // Find director by id
        System.out.println("Average takings of all director movies by director id: ");
        System.out.println(movieService.moviesAverageIncome_byDirectorID(6));

        System.out.println();
        System.out.println("-----------");
        System.out.println();


        //  #   #   #   #   #
        //  #
        //  #
        //  #   Find movie by ID
        //  #
        //  #
        //  #   #   #   #   #

        // Find movie by ID
        System.out.println("Find movie by ID: ");
        movieService.findMovie(3).ifPresentOrElse(System.out::println, () -> System.out.println("not"));

        System.out.println();
        System.out.println("-----------");
        System.out.println();

        //  #   #   #   #   #
        //  #
        //  #
        //  #   Movie with highest takings
        //  #
        //  #
        //  #   #   #   #   #

        // Movie with the highest takings:
        System.out.println("Movie with the highest takings: ");
        System.out.println(movieService.movieWithHighestTakings());

        System.out.println();
        System.out.println("-----------");
        System.out.println("-----------");
        System.out.println("-----------");
        System.out.println();

        //  #   #   #   #   #
        //  #
        //  #
        //  #   All Movies by Director ID
        //  #
        //  #
        //  #   #   #   #   #

        // Find all movies by director ID
        System.out.println("All Movies by Director ID: ");
        movieService.findAllMovies_ByDirectorID(6).forEach(System.out::println);

        System.out.println();
        System.out.println("-----------");
        System.out.println();

        //  #   #   #   #   #
        //  #
        //  #
        //  #   Add New Movie
        //  #
        //  #
        //  #   #   #   #   #

        System.out.println("All Movies before adding new movie: ");
        movieService.getAll().forEach(System.out::println);
        System.out.println();

        // Add Movie (Successful - Unsuccessful)
        System.out.println("Add movie all ok:" + movieService.addMovie(new Movie(8, "FIRST_NAME222_222", 1997, 1000000, 5)));
        System.out.println("Add movie not ok (the ID is already taken):" + movieService.addMovie(new Movie(2, "FIRST_NAME222_222", 1997, 1000000, 5)));

        // List all movies
        System.out.println();
        System.out.println("All Movies: ");
        movieService.getAll().forEach(System.out::println);




    }
}
