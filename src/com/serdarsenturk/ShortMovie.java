package com.serdarsenturk;

import java.util.ArrayList;

public class ShortMovie extends Movie{
    private String title;
    private int timeLength;
    private ArrayList<String> competitions;

    public ShortMovie(int id, String name, Genre genre,String title, String author, int timeLength){
        super(id, name, genre, author, title);
        this.timeLength = timeLength;
        this.competitions = new ArrayList<>();
    }

    public void addCompetition(String competition){
        this.competitions.add(competition);
    }


    public String getTitle(){
        return "Min: " + this.timeLength + this.title;
    }

    public int getTimeLength(){
        return this.timeLength;
    }

    public Iterable<String> getCompetitions(){
        var compList = this.competitions;
        return new ArrayList<>(compList);
    }
}
