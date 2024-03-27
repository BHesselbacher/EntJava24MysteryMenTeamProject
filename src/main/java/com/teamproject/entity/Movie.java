package com.teamproject.entity;

public class Movie {
    private int movieId;
    private String title;
    private String director;
    private int durationMinutes;

    // Constructor
    public Movie(String title, String director, int durationMinutes) {
        this.title = title;
        this.director = director;
        this.durationMinutes = durationMinutes;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public void setDurationMinutes(int durationMinutes) {
        this.durationMinutes = durationMinutes;
    }
}
