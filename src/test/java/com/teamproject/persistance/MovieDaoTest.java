package com.teamproject.persistance;

import com.teamproject.entity.Movie;
import com.teamproject.entity.Theater;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class MovieDaoTest {
    private MovieDao movieDao;

    @BeforeEach
    public void setUp() {
        movieDao = new MovieDao();
    }

    @Test
    public void testInsertAndGetById() {
        Movie movie = new Movie("Inception", "Christopher Nolan", 148, new Theater());
        int id = movieDao.insert(movie);
        Movie retrievedMovie = movieDao.getById(id);
        assertEquals(movie, retrievedMovie);
    }

    @Test
    public void testUpdate() {
        Movie movie = new Movie("Inception", "Christopher Nolan", 148, new Theater());
        int id = movieDao.insert(movie);
        Movie updatedMovie = new Movie("Inception", "Christopher Nolan", 160, new Theater());
        updatedMovie.setMovieId(id);
        assertTrue(movieDao.update(updatedMovie));
        assertEquals(updatedMovie, movieDao.getById(id));
    }

    @Test
    public void testDelete() {
        Movie movie = new Movie("Inception", "Christopher Nolan", 148, new Theater());
        int id = movieDao.insert(movie);
        assertTrue(movieDao.delete(movie));
        assertNull(movieDao.getById(id));
    }

    @Test
    public void testGetAll() {
        Movie movie1 = new Movie("Inception", "Christopher Nolan", 148, new Theater());
        Movie movie2 = new Movie("The Matrix", "Lana Wachowski, Lilly Wachowski", 136, new Theater());
        movieDao.insert(movie1);
        movieDao.insert(movie2);
        List<Movie> movies = movieDao.getAll();
        assertEquals(2, movies.size());
        assertTrue(movies.contains(movie1));
        assertTrue(movies.contains(movie2));
    }
}
