package com.teamproject.persistance;

import com.teamproject.entity.Movie;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

public class MovieDao implements Dao<Movie> {

    private final ConcurrentMap<Integer, Movie> movieDatabase = new ConcurrentHashMap<>();
    private final AtomicInteger nextId = new AtomicInteger(1);

    @Override
    public List<Movie> getAll() {
        return new ArrayList<>(movieDatabase.values());
    }

    @Override
    public Movie getById(int id) {
        return movieDatabase.get(id);
    }

    @Override
    public int insert(Movie entity) {
        int id = nextId.getAndIncrement();
        entity.setMovieId(id);
        movieDatabase.put(id, entity);
        return id;
    }

    @Override
    public boolean update(Movie entity) {
        if (movieDatabase.containsKey(entity.getMovieId())) {
            movieDatabase.put(entity.getMovieId(), entity);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Movie entity) {
        return movieDatabase.remove(entity.getMovieId()) != null;
    }
}
