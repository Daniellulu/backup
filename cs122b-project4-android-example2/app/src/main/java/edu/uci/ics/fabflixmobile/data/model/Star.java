package edu.uci.ics.fabflixmobile.data.model;

/**
 * Star class that captures star information for stars associated with movies
 */
public class Star {
    private final String name;
    private final String id;

    public Star(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }
}