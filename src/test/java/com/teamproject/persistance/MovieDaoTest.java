package com.teamproject.persistance;

import com.teamproject.entity.Movie;
import com.teamproject.entity.Theater;
import com.teamproject.util.Database;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Tests the movie dao
 */
public class MovieDaoTest {
    private GenericDao<Movie> dao;
    private GenericDao<Theater> theaterDao;
    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Setup before each test
     */
    @BeforeEach
    public void setUp() {
        Database database = Database.getInstance();
        database.runSQL("dump.sql");
        database.runSQL("tempSQLInsertTheater.sql");
        database.runSQL("tempSQLInsertMovie.sql");
        dao = new GenericDao<>(Movie.class);
        theaterDao = new GenericDao<>(Theater.class);
    }

    /**
     * Tests getting by id
     */
    @Test
    void getByIDSuccess() {
        Movie retrievedMovie = dao.getById(1);
        assertEquals("testMovie", retrievedMovie.getTitle());
        logger.info(retrievedMovie);
    }

    /**
     * Tests update
     */
    @Test
    void testUpdate() {
        Movie movie = dao.getById(1);
        Movie oldMovie = new Movie(movie);
        movie.setTitle("testMovie2");
        dao.update(movie);
        logger.info(dao.getById(1) + "");
        logger.info(oldMovie);
        assertFalse(oldMovie.equals(dao.getById(1)));
    }

    /**
     * Tests getting all
     */
    @Test
    void testGetAll() {
        ArrayList<Movie> movies = (ArrayList<Movie>) dao.getAll();
        assertTrue(movies.size() == 1);
    }


    /**
     * Tests inserting then deleting
     */
    @Test
    void insertAndDeleteSuccess() {
        Movie newMovie = new Movie("testy", "Real Person", 111,theaterDao.getById(1));
        int result = dao.insert(newMovie);
        assertTrue(dao.getById(result).equals(newMovie));

        dao.delete(newMovie);
        assertNull(dao.getById(result));
    }

    /**
     * Tests getting by property
     */
    @Test
    void testGetProperty() {
        ArrayList<Movie> movies = (ArrayList<Movie>) dao.getByProperty("title", "testMovie");
        logger.info(movies);
        logger.info(dao.getById(1) + "");
        assertTrue(movies.get(0).equals(dao.getById(1)));
    }
}
