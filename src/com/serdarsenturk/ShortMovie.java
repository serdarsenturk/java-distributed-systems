package com.serdarsenturk;

import java.util.ArrayList;

public class ShortMovie extends Movie{
    private String author;
    private ArrayList<String> competitions;

    public ShortMovie(int id, String name, Genre genre, String author){
        super(id, name, genre);
        this.author = author;
        this.competitions = new ArrayList<>();
    }

    public String getAuthor(){
        return this.author;
    }

    public void addCompetition(String competition){
        this.competitions.add(competition);
    }

    public Iterable<String> getCompetitions(){
        var compList = this.competitions;
        return new ArrayList<>(compList);
    }
}
