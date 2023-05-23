package edu.uci.ics.fabflixmobile.data.model;

/**
 * Genre class that captures genre information for genres associated with movies
 */
public class Genre {
    private final String id;
    private final String name;

    public Genre(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
