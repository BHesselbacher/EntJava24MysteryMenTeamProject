package com.teamproject.restService;

import com.teamproject.entity.Movie;
import com.teamproject.entity.Theater;
import com.teamproject.persistance.MovieDao;
import com.teamproject.persistance.TheaterDao;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/theater")
public class MovieTheater {
    // Initialize the DAO instance
    private MovieDao movieDao = new MovieDao();
    private TheaterDao theaterDao = new TheaterDao();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllMovies() {
        // Logic to retrieve all moviees from the database
        List<Movie> allMovies = movieDao.getAll();

        // Check if any moviees were found
        if (allMovies.isEmpty()) {
            // If no movies were found, return 404 Not Found status
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            // If movies were found, return them as JSON
            GenericEntity<List<Movie>> entity = new GenericEntity<List<Movie>>(allMovies) {};
            return Response.ok(entity).build();
        }
    }
    @GET
    @Path("/movies/{movieId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMovieById(@PathParam("movieId") int movieId) {
        // Logic to retrieve movie by ID from the database
        Movie movie = movieDao.getById(movieId);

        // Check if movie is found
        if (movie == null) {
            // If movie not found, return 404 Not Found status
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            // If movie found, return it as JSON
            return Response.ok(movie).build();
        }
    }

    @GET
    @Path("/theaters/{theaterId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTheaterById(@PathParam("theaterId") int theaterId) {
        // Logic to retrieve movie by ID from the database
        Theater theater = theaterDao.getById(theaterId);

        // Check if movie is found
        if (theater == null) {
            // If movie not found, return 404 Not Found status
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            // If movie found, return it as JSON
            return Response.ok(theater).build();
        }
    }
}


