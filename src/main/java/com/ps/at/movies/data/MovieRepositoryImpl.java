package com.ps.at.movies.data;

import com.ps.at.movies.model.Genre;
import com.ps.at.movies.model.Movie;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class MovieRepositoryImpl implements MovieRepository {

    private JdbcTemplate jdbcTemplate;

    public MovieRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Movie findById(long id) {

        Object[] args = {id};
        return jdbcTemplate.queryForObject("SELECT * FROM movies WHERE id = ?",
                args, movieMapper);
    }

    @Override
    public Collection<Movie> findAll() {

        return jdbcTemplate.query("SELECT * FROM movies", movieMapper );
    }

    @Override
    public void saveOrUpdate(Movie movie) {

        jdbcTemplate.update("insert into movies (name, minutes,director, genre) values\n" +
                "(?,?,?,?)", movie.getName(), movie.getMinutes(),movie.getDirector(), movie.getGenre().toString());

    }

    @Override
    public Collection<Movie> findByName(String name) {
        String[] args = {"%" + name + "%"};
        Collection<Movie> moviesResult = new ArrayList<>();
        Collection<Movie> moviesFound = jdbcTemplate.query("SELECT * FROM movies WHERE name like ?",
                args, movieMapper);
        for (Movie mf : moviesFound) {
            if (mf.getName().contains(name)){
                moviesResult.add(mf);
            }
        }
        return moviesResult;
    }

    @Override
    public Collection<Movie> findByDirector(String name) {
        String[] args = {"%" + name + "%"};
        Collection<Movie> moviesResult = new ArrayList<>();
        Collection<Movie> moviesFound = jdbcTemplate.query("SELECT * FROM movies WHERE director like ?",
                args, movieMapper);
        for (Movie mf : moviesFound) {
            if (mf.getDirector().contains(name)){
                moviesResult.add(mf);
            }
        }
        return moviesResult;
    }

    private static RowMapper<Movie> movieMapper = new RowMapper<Movie>() {
        @Override
        public Movie mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Movie(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getInt("minutes"),
                    rs.getString("director"),
                    Genre.valueOf(rs.getString("genre")));
        }
    };
}
