package com.teamproject.entity;

import jakarta.persistence.*;

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
    // Constructor
    public Movie(String title, String director, int durationMinutes, Theater theater) {
        this.title = title;
        this.director = director;
        this.durationMinutes = durationMinutes;
        this.theater = theater;
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

    public Theater getTheater() {
        return theater;
    }

    public void setTheater(Theater theater) {
        this.theater = theater;
    }
}
