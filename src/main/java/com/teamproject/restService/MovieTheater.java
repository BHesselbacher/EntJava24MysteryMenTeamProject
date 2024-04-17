package com.teamproject.restService;

import com.teamproject.entity.Movie;
import com.teamproject.entity.Theater;
import com.teamproject.persistance.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.*;
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

    Logger logger = LogManager.getLogger(this.getClass());

    /**
     * fetches all movies
     * @return http response
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/movies")
    public Response getAllMovies() {
        // Logic to retrieve all movies from the database
        List<Movie> allMovies = movieDao.getAll();
        return fetchAllResponse(allMovies);
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
        return fetchAllResponse(allTheaters);
    }

    /**
     * Handles returning a list of movies of theaters
     * @param list list of movies or theaters
     * @return http response for the list
     */
    private Response fetchAllResponse(List list) {
        if (list.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            GenericEntity<List> entity = new GenericEntity<>(list) {
            };
            return Response.ok(entity).build();
        }
    }

    /**
     * Fetches a movie based on id
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
     * Fetches a movie based on title
     * @param movieTitle title to search for
     * @return http response
     */
    @GET
    @Path("/movies/title/{movieTitle}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMovieByTitle(@PathParam("movieTitle") String movieTitle) {
        List<Movie> movie = movieDao.getByPropertyLike("title", movieTitle);

        if (movie.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            return Response.ok(movie).build();
        }
    }

    // TODO better responses?

    /**
     * Fetches a theaer based on name
     * @param theaterName name to search for
     * @return http response
     */
    @GET
    @Path("/theaters/name/{theaterName}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTheaterByTitle(@PathParam("theaterName") String theaterName) {
        List<Theater> theaters = theaterDao.getByPropertyLike("theaterName", theaterName);

        if (theaters.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            return Response.ok(theaters).build();
        }
    }

    /**
     * Adds a movie
     * @param movie movie to add, from JSON
     * @return JSON of added movie, or error if bad request
     */
    @POST
    @Path("/movies")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response putMovie(Movie movie) {

        int id;
        id = movie.getTheater().getTheaterId();


        // Checks if this movie's theater already exists
        // If not, it will be added
        // Theater must match exactly, or it will make a new one
        // To avoid exact matching, maybe only check id?
        if (theaterDao.getById(id).equals(movie.getTheater())) {
            movie.setTheater(theaterDao.getById(id));
        } else {
            Theater theater = movie.getTheater();
            theater.setTheaterId(theaterDao.insert(theater));
        }

        if ((id = movieDao.insert(movie)) > -1) {
            return Response.ok(movieDao.getById(id)).build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    /**
     * Adds a theater
     * @param theater theater to add, from JSON
     * @return JSON of added movie, or error if bad request
     */
    @POST
    @Path("/theaters")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response putTheater(Theater theater) {
        int id;

        if ((id = theaterDao.insert(theater)) > -1) {
            return Response.ok(theaterDao.getById(id)).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
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

    /**
     * Deletes a movie
     * @param id movie id
     */
    @DELETE
    @Path("/movies/{id}")
    public void deleteMovie(@PathParam("id") int id) {
        Movie temp = movieDao.getById(id);
        movieDao.delete(temp);
    }

    /**
     * Deletes a theater
     * @param id theater id
     */
    @DELETE
    @Path("/theaters/{id}")
    public void deleteTheater(@PathParam("id") int id) {
        Theater temp = theaterDao.getById(id);
        theaterDao.delete(temp);
    }
}


