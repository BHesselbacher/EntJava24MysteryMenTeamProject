package com.teamproject.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

/**
 * Represents a movie object
 */
@Entity
@Table(name = "Movie")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movieId")
    private int movieId;
    @Column(name = "title")
    private String title;
    @Column(name = "director")
    private String director;
    @Column(name = "duration")
    private int durationMinutes;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "theaterId")
    private Theater theater;
    public Movie() {
    }

    /**
     * Constructs a movie object
     * @param title movie title
     * @param director director name
     * @param durationMinutes runtime
     * @param theater theater
     */
    public Movie(String title, String director, int durationMinutes, Theater theater) {
        this.title = title;
        this.director = director;
        this.durationMinutes = durationMinutes;
        this.theater = theater;
    }

    /**
     * Constructs a movie based on another movie
     * @param newMovie Movie to be copied
     */
    public Movie(Movie newMovie) {
        this.title = newMovie.title;
        this.director = newMovie.director;
        this.durationMinutes = newMovie.durationMinutes;
        this.theater = newMovie.theater;
    }


    /**
     * Gets movie id
     * @return movie id
     */
    public int getMovieId() {
        return movieId;
    }

    /**
     * Sets movie id
     * @param movieId movie id
     */
    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    /**
     * Gets the movie title
     * @return movie title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the movie title
     * @param title movie title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the movie director
     * @return movie director
     */
    public String getDirector() {
        return director;
    }

    /**
     * Sets the movie director
     * @param director movie director
     */
    public void setDirector(String director) {
        this.director = director;
    }

    /**
     * Gets the movie runtime
     * @return movie runtime
     */
    public int getDurationMinutes() {
        return durationMinutes;
    }

    /**
     * Sets the movie runtime
     * @param durationMinutes movie runtime
     */
    public void setDurationMinutes(int durationMinutes) {
        this.durationMinutes = durationMinutes;
    }

    /**
     * Gets the theater
     * @return theater
     */
    public Theater getTheater() {
        return theater;
    }

    /**
     * Sets the theater
     * @param theater theater
     */
    public void setTheater(Theater theater) {
        this.theater = theater;
    }

    /**
     * Gets string of data
     * @return string-ified data
     */
    @Override
    public String toString() {
        return "Movie{" +
                "movieId=" + movieId +
                ", title='" + title + '\'' +
                ", director='" + director + '\'' +
                ", durationMinutes=" + durationMinutes +
                ", theater=" + theater +
                '}';
    }

    /**
     * Compares Movie objects
     * @param o object to be compared
     * @return if object equals this instance
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || o.getClass() != getClass()) return false;
        Movie movie = (Movie) o;
        return (movieId == movie.movieId && title.equals(movie.title) &&
                director.equals(movie.director) && durationMinutes == movie.durationMinutes
                && theater.equals(movie.theater));
    }
}
