package com.teamproject.restService;

import com.teamproject.entity.Movie;
import com.teamproject.entity.Theater;
import com.teamproject.persistance.GenericDao;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * MovieTheater api
 */
@Path("/theater")
public class MovieTheater {
    // Initialize the DAO instance

    private GenericDao<Movie> movieDao = new GenericDao<>(Movie.class);
    private GenericDao<Theater> theaterDao = new GenericDao<>(Theater.class);

    /**
     * fetches all movies
     * @return http response
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/movies")
    public Response getAllMovies() {
        // Logic to retrieve all moviees from the database
        List<Movie> allMovies = movieDao.getAll();

        // Check if any moviees were found
        if (allMovies.isEmpty()) {
            // If no movies were found, return 404 Not Found status
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            // If movies were found, return them as JSON
            GenericEntity<List<Movie>> entity = new GenericEntity<>(allMovies) {
            };
            return Response.ok(entity).build();
        }
    }

    /**
     * fetches all theaters
     * @return http response
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/theaters")
    public Response getAllTheaters() {
        // Logic to retrieve all theaters from the database
        List<Theater> allTheaters = theaterDao.getAll();

        // Check if any moviees were found
        if (allTheaters.isEmpty()) {
            // If no movies were found, return 404 Not Found status
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            // If movies were found, return them as JSON
            GenericEntity<List<Theater>> entity = new GenericEntity<>(allTheaters) {
            };
            return Response.ok(entity).build();
        }
    }

    /**
     * fetches movie based on id
     * @param movieId id to fetch
     * @return http response
     */
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

    /**
     * Fetches theater based on id
     * @param theaterId id to fetch
     * @return http response
     */
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


