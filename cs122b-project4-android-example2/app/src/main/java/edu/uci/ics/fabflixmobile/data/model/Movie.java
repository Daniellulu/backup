package edu.uci.ics.fabflixmobile.data.model;

import java.util.ArrayList;

/**
 * Movie class that captures movie information for movies retrieved from MovieListActivity
 */
public class Movie {
    private final String title;
    private final short year;
    private final String id;
    private final String director;
    private ArrayList<Genre> genres = new ArrayList<Genre>();

    private ArrayList<Star> stars = new ArrayList<Star>();

    public Movie(String name, short year, String id, String director, ArrayList<Star> stars, ArrayList<Genre> genres) {
        this.title = name;
        this.year = year;
        this.id = id;
        this.director = director;
        this.stars = stars;
        this.genres = genres;

    }

    public String getName() {
        return title;
    }

    public short getYear() {
        return year;
    }
}