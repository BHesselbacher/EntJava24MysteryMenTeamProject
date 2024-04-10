package com.teamproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;

import java.util.List;

/**
 * Represents a theater object
 */
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

    @OneToMany(mappedBy = "theater", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnoreProperties("Theater")
    private List<Movie> movies;

    /**
     * Default constructor
     */
    public Theater() {
    }

    /**
     * Constructs a theater object
     * @param theaterId theater id
     * @param theaterName theater name
     * @param ticketCost ticket cost
     */
    public Theater(int theaterId, String theaterName, double ticketCost) {
        this.theaterId = theaterId;
        this.theaterName = theaterName;
        this.ticketCost = ticketCost;
    }

    /**
     * Gets the theater id
     * @return theater id
     */
    public int getTheaterId() {
        return theaterId;
    }

    /**
     * Sets the theater id
     * @param theaterId theater id
     */
    public void setTheaterId(int theaterId) {
        this.theaterId = theaterId;
    }

    /**
     * Gets the theater name
     * @return theater name
     */
    public String getTheaterName() {
        return theaterName;
    }

    /**
     * Sets the theater name
     * @param theaterName theater name
     */
    public void setTheaterName(String theaterName) {
        this.theaterName = theaterName;
    }

    /**
     * Gets the ticket cost
     * @return ticket cost
     */
    public double getTicketCost() {
        return ticketCost;
    }

    /**
     * Sets the ticket cost
     * @param ticketCost ticket cost
     */
    public void setTicketCost(double ticketCost) {
        this.ticketCost = ticketCost;
    }

    /**
     * Gets associated movies
     * @return movie list
     */
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || o.getClass() != getClass()) return false;
        Theater theater = (Theater) o;
        return (theaterId == theater.theaterId && theaterName.equals(theater.theaterName)
            && ticketCost == theater.ticketCost);
    }
}
