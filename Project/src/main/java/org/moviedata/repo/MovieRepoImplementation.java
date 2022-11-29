package org.moviedata.repo;

import org.moviedata.entities.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public class MovieRepoImplementation implements MovieRepo{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    @Override
    public int count() {
        String sql = "SELECT count(*) FROM Movie";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    @Override
    public boolean exists(int id) {
        String sql = "SELECT count(*) FROM Movie WHERE movieId = :movieId";

        SqlParameterSource sqlParameterSource = new MapSqlParameterSource().addValue("movieId", id);

        Integer number = namedParameterJdbcTemplate.queryForObject(sql, sqlParameterSource, Integer.class);


        return number != null && number == 1;
    }

    @Override
    public int deleteMovie(int id) {
        String sql = "delete FROM Movie WHERE movieId = :movieId";

        SqlParameterSource sqlParameterSource = new MapSqlParameterSource().addValue("movieId", id);

        return namedParameterJdbcTemplate.update(sql, sqlParameterSource);
    }


    @Override
    public float moviesAverageIncome_byDirectorID(int id) {

        String sql = "SELECT avg(movieTakings) FROM movie where movieDirectorID = :movieDirectorID";


        SqlParameterSource sqlParameterSource = new MapSqlParameterSource().addValue("movieDirectorID", id);


        return namedParameterJdbcTemplate.queryForObject(sql, sqlParameterSource, Float.class);
    }




    @Override
    public String movieWithHighestTakings() {

        String sql = " SELECT concat('Movie title: ', m.movieTitle, ' Director name: ',d.firstName, ' ', d.lastName) FROM movie m INNER JOIN director d on m.movieDirectorID = d.directorID where movieTakings = (SELECT max(movieTakings) from movie) ";

        return namedParameterJdbcTemplate.getJdbcTemplate().queryForObject(sql, String.class);
    }



    @Override
    public int modifyMovieTakings(int id, int movie_new_takings) {
        String sql = "update movie set movieTakings = :movieTakings where movieID = :id ";


        SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
                .addValue("id", id)
                .addValue("movieTakings", movie_new_takings);

        return namedParameterJdbcTemplate.update(sql, sqlParameterSource);
    }

    @Override
    public int createMovie(Movie newMovie) {
        String sql = "insert into movie values (:movieId, :movie_name, :movie_year_released, :movie_takings, :movie_director_id)";

        SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
                .addValue("movieId", newMovie.getMovieID())
                .addValue("movie_name", newMovie.getMovieTitle())
                .addValue("movie_year_released", newMovie.getMovieYearReleased())
                .addValue("movie_takings", newMovie.getMovieTakings())
                .addValue("movie_director_id", newMovie.getMovieDirectorID());

        return namedParameterJdbcTemplate.update(sql, sqlParameterSource);
    }


    @Override
    public List<Movie> getAll() {
        String sql = "SELECT * FROM movie";
        return jdbcTemplate.query(sql, new MovieRowMapper());
    }


    @Override
    public List<Movie> findAllMovies_ByDirectorID(int id) {

        String sql = "SELECT * FROM movie where movieDirectorID = :id";
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource().addValue("id", id);

        return namedParameterJdbcTemplate.query(sql, sqlParameterSource, new MovieRowMapper());

    }



    @Override
    public Movie findMovie_ByID(int id) {

        String sql = "SELECT * FROM movie where movieID = :id";
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource().addValue("id", id);

        return namedParameterJdbcTemplate.queryForObject(sql, sqlParameterSource, new MovieRowMapper());
    }


}
