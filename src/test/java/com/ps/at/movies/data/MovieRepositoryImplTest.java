package com.ps.at.movies.data;

import com.ps.at.movies.model.Genre;
import com.ps.at.movies.model.Movie;
import static org.hamcrest.CoreMatchers.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import javax.sql.DataSource;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

public class MovieRepositoryImplTest {

    private MovieRepositoryImpl mr;
    private DataSource ds;

    @Before
    public void setUp() throws Exception {

        ds = new DriverManagerDataSource("jdbc:h2:mem:test;MODE=MYSQL", "sa", "sa");

        ScriptUtils.executeSqlScript(ds.getConnection(), new ClassPathResource("sql-scripts/test-data.sql"));

        JdbcTemplate jdbcTemplate = new JdbcTemplate(ds);
        mr = new MovieRepositoryImpl(jdbcTemplate);
    }

    @Test
    public void load_all_movies() throws SQLException {


        Collection<Movie> movies = mr.findAll();

        assertThat(movies, is(Arrays.asList(
                new Movie(1,"Dark Knight", 152,"PEPITO", Genre.ACTION),
                new Movie(2,"STAR WARS: The empire strikes back", 258,"GEORGE LUCAS", Genre.THRILLER),
                new Movie(3,"STAR WARS: The return of the Jedi", 258,"GEORGE LUCAS", Genre.THRILLER),
                new Movie(4,"STAR WARS: a new hope", 258,"GEORGE LUCAS", Genre.THRILLER),
                new Movie(5,"Matrix", 182,"PEPITO", Genre.ACTION)
        )));

    }

    @Test
    public void load_movie_by_id() {

        Movie movie =mr.findById(2);
        assertThat(movie, is( new Movie(2,"STAR WARS: The empire strikes back", 258,"GEORGE LUCAS", Genre.THRILLER)));
    }

    @Test
    public void insert_a_movie() {
        Movie movie = new Movie("The Lord of The Rings", 152,"PETER JACKSON", Genre.THRILLER);
        mr.saveOrUpdate(movie);

        Movie movieSaved = mr.findById(6);
        assertThat(movieSaved, is(new Movie(6,"The Lord of The Rings", 152,"PETER JACKSON", Genre.THRILLER)));
    }

    @Test
    public void find_movies_by_name() {
        Collection<Movie> movies = mr.findByName("WARS");

        assertThat(movies, is(Arrays.asList(
                new Movie(2,"STAR WARS: The empire strikes back", 258,"GEORGE LUCAS", Genre.THRILLER),
                new Movie(3,"STAR WARS: The return of the Jedi", 258,"GEORGE LUCAS", Genre.THRILLER),
                new Movie(4,"STAR WARS: a new hope", 258,"GEORGE LUCAS", Genre.THRILLER)
        )));
    }

    @Test
    public void find_movies_by_director() {
        Collection<Movie> movies = mr.findByDirector("LUCAS");

        assertThat(movies, is(Arrays.asList(
                new Movie(2,"STAR WARS: The empire strikes back", 258,"GEORGE LUCAS", Genre.THRILLER),
                new Movie(3,"STAR WARS: The return of the Jedi", 258,"GEORGE LUCAS", Genre.THRILLER),
                new Movie(4,"STAR WARS: a new hope", 258,"GEORGE LUCAS", Genre.THRILLER)
        )));
    }

    @After
    public void tearDown() throws Exception {

        final Statement st = ds.getConnection().createStatement();
        st.execute("drop all objects delete files");
    }
}