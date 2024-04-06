package com.teamproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Theater")
@JsonInclude(JsonInclude.Include.NON_NULL) // Include only non-null fields in JSON serialization
public class Theater {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "theaterId", nullable = false)
    private int theaterId;
    @Column(name = "theaterName", nullable = false)
    private String theaterName;
    @Column(name = "ticketCost", nullable = false)
    private double ticketCost;

    @OneToMany(mappedBy = "Theater", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnoreProperties("Theater")
    private List<Movie> movies;

    public Theater() {
    }

    public Theater(int theaterId, String theaterName, double ticketCost) {
        this.theaterId = theaterId;
        this.theaterName = theaterName;
        this.ticketCost = ticketCost;
    }

    public int getTheaterId() {
        return theaterId;
    }

    public void setTheaterId(int theaterId) {
        this.theaterId = theaterId;
    }

    public String getTheaterName() {
        return theaterName;
    }

    public void setTheaterName(String theaterName) {
        this.theaterName = theaterName;
    }

    public double getTicketCost() {
        return ticketCost;
    }

    public void setTicketCost(double ticketCost) {
        this.ticketCost = ticketCost;
    }

    public List<Movie> getMovies() {
        return movies;
    }
    @Override
    public String toString() {
        return "Theater{" +
                "theaterId=" + theaterId +
                ", theaterName='" + theaterName + '\'' +
                ", ticketCost=" + ticketCost +
                '}';
    }
}
