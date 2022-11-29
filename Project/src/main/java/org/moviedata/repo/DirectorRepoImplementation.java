package org.moviedata.repo;

import org.moviedata.entities.Director;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.beans.Statement;
import java.util.List;

@Repository

public class DirectorRepoImplementation implements DirectorRepo{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

//    @Override
//    public boolean existsByName(String name) {
//        String sql = "SELECT count(*) FROM Director where firstName ";
//        return jdbcTemplate.queryForObject(sql, Integer.class);
//    }



    @Override
    public int count() {
        String sql = "SELECT count(*) FROM Director";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    @Override
    public boolean exists(int id) {
        String sql = "SELECT count(*) FROM Director WHERE directorId = :directorId";

        SqlParameterSource sqlParameterSource = new MapSqlParameterSource().addValue("directorId", id);

        Integer number = namedParameterJdbcTemplate.queryForObject(sql, sqlParameterSource, Integer.class);


        return number != null && number == 1;
    }



    @Override
    public int deleteDirector(int id) {
        String sql = "delete FROM Director WHERE directorId = :directorId";

        SqlParameterSource sqlParameterSource = new MapSqlParameterSource().addValue("directorId", id);

        return namedParameterJdbcTemplate.update(sql, sqlParameterSource);
    }



    @Override
    public int changeDirectorStatus(int id, int make_active_or_inactive) {
        String sql = "update director set isActive = :isActive where directorId = :id ";

        int newValue = 1;

        if (make_active_or_inactive == 1) {
            newValue = 1;

        } else {
            newValue = 0;
        }

        SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
                .addValue("id", id)
                .addValue("isActive", newValue);



        return namedParameterJdbcTemplate.update(sql, sqlParameterSource);
    }

    @Override
    public int createDirector(Director newDirector) {
        String sql = "insert into director values (:id, :first_name, :last_name, :isActive)";

        SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
                .addValue("id", newDirector.getDirectorId())
                .addValue("first_name", newDirector.getFirstName())
                .addValue("last_name", newDirector.getLastName())
                .addValue("isActive", newDirector.getIsActive());



        return namedParameterJdbcTemplate.update(sql, sqlParameterSource);
    }


    @Override
    public List<Director> getAll() {
        String sql = "SELECT * FROM Director";
        return jdbcTemplate.query(sql, new DirectorRowMapper() );
    }



    @Override
    public int getNumberOfInactiveDirectors() {

        String sql = "SELECT count(*) FROM director where isActive = 0";




        return namedParameterJdbcTemplate.getJdbcTemplate().queryForObject(sql, Integer.class);
    }



    @Override
    public Director findDirector(int id) {


        String sql = "SELECT * FROM director where directorId = :id";
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource().addValue("id", id);


        return namedParameterJdbcTemplate.queryForObject(sql, sqlParameterSource, new DirectorRowMapper());
    }
}
