package com.teamproject.persistance;

import com.teamproject.entity.Movie;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovieDao implements Dao<Movie> {
    private Map<Integer, Movie> movieDatabase = new HashMap<>();
    private int nextId = 1;

    @Override
    public List<Movie> getAll() {
        return new ArrayList<>(movieDatabase.values());
    }

    @Override
    public Movie getById(int id) {
        return movieDatabase.get(id);
    }

    @Override
    public int insert(Movie movie) {
        movie.setMovieId(nextId);
        movieDatabase.put(nextId, movie);
        return nextId++;
    }

    @Override
    public boolean update(Movie movie) {
        if (movieDatabase.containsKey(movie.getMovieId())) {
            movieDatabase.put(movie.getMovieId(), movie);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Movie movie) {
        return movieDatabase.remove(movie.getMovieId()) != null;
    }
}
