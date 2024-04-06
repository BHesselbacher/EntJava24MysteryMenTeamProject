package com.teamproject.persistance;

import com.teamproject.entity.Theater;
import com.teamproject.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TheaterDaoTest {

    TheaterDao dao = new TheaterDao();
    MovieDao movieDao = new MovieDao();

    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("dump.sql");
        database.runSQL("tempSQLInsertTheater.sql");
        database.runSQL("tempSQLInsertMovie.sql");

        dao = new TheaterDao();
        movieDao = new MovieDao();
    }

    @Test
    void getByIDSuccess() {
        Theater retrievedTheater = dao.getById(1);
        assertEquals("test", retrievedTheater.getTheaterName());
    }


}
