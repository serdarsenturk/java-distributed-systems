package com.serdarsenturk;

import java.util.ArrayList;

public class ShortMovie extends Movie {
    private String title;
    private int runtime;
    private ArrayList<String> competitions;

    public ShortMovie(int id, String originalTitle, Genre genre,String title, int runtime){
        super(id, originalTitle, genre, title);
        this.runtime = runtime;
        this.competitions = new ArrayList<>();
    }

    public void addCompetition(String competition){
        this.competitions.add(competition);
    }


    public String getTitle(){
        return "Min: " + this.runtime + this.title;
    }

    public int getRuntime(){
        return this.runtime;
    }

    public Iterable<String> getCompetitions(){
        var compList = this.competitions;
        return new ArrayList<>(compList);
    }
}
