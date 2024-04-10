package com.teamproject.persistance;

import com.teamproject.entity.Movie;
import com.teamproject.entity.Theater;
import com.teamproject.util.Database;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests the movie dao
 */
public class TheaterDaoTest {

    GenericDao<Theater> dao;
    GenericDao<Movie> movieDao;
    private Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Setup before each test
     */
    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("dump.sql");
        database.runSQL("tempSQLInsertTheater.sql");
        database.runSQL("tempSQLInsertMovie.sql");

        dao = new GenericDao<>(Theater.class);
        movieDao = new GenericDao<>(Movie.class);
    }

    /**
     * Tests getting by id
     */
    @Test
    void getByIDSuccess() {
        Theater retrievedTheater = dao.getById(1);
        assertEquals("test", retrievedTheater.getTheaterName());
        logger.info(retrievedTheater);
    }

    /**
     * Tests update
     */
    @Test
    void testUpdate() {
        Theater theater = dao.getById(1);
        Theater oldTheater = new Theater(theater.getTheaterId(), theater.getTheaterName(), theater.getTicketCost());
        theater.setTheaterName("test2");
        dao.update(theater);
        logger.info(dao.getById(1) + "");
        logger.info(oldTheater);
        assertFalse(oldTheater.equals(dao.getById(1)));
    }

    /**
     * Tests getting all
     */
    @Test
    void testGetAll() {
        ArrayList<Theater> theaters = (ArrayList<Theater>) dao.getAll();
        assertTrue(theaters.size() == 2);
    }

    /**
     * Tests inserting then deleting
     */
    @Test
    void insertAndDeleteSuccess() {
        Theater newTheater = new Theater(1,"theater", 11.11);
        int result = dao.insert(newTheater);
        assertTrue(dao.getById(result).equals(newTheater));

        dao.delete(newTheater);
        assertNull(dao.getById(result));
    }

    /**
     * Tests getting by property
     */
    @Test
    void testGetProperty() {
        ArrayList<Theater> theaters = (ArrayList<Theater>) dao.getByProperty("theaterName", "test");
        logger.info(theaters);
        assertTrue(theaters.get(0).equals(dao.getById(1)));
    }



}
