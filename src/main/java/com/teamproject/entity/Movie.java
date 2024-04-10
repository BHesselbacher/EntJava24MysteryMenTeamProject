package com.teamproject.entity;

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
}
