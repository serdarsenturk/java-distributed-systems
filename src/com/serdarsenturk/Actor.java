package com.serdarsenturk;

import java.util.ArrayList;
import java.util.HashMap;

public class Actor {
    private int actorId;
    private String name;
    private int age;
    private HashMap<String, Movie> movies;

    public Actor(int actorId, String name, int age){
        this.actorId = actorId;
        this.name = name;
        this.age = age;
        this.movies = new HashMap<>();
    }

    public String getName(){
        return this.name;
    }

    public int getAge(){
        return this.age;
    }

    public int getActorId(){
        return this.actorId;
    }

    public Iterable<Movie> getMovies(){
        var actorsDicValues = this.movies.values();
        return new ArrayList<>(actorsDicValues);
    }

    public void addMovies(Movie movie){
        this.movies.put(movie.getName(), movie);
    }
}
