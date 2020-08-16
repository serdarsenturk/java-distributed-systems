package com.serdarsenturk;

public class LongTimeMovie extends Movie {
    private int timeLength;
    private String title;

    public LongTimeMovie(int id, String originalTitle, String title, Genre genre, int timeLength){
        super(id, originalTitle, title, genre);
        this.timeLength = timeLength;
    }

    public int getTimeLength(){
        return this.timeLength;
    }

    public String getTitle(){
        return this.title;
    }
}