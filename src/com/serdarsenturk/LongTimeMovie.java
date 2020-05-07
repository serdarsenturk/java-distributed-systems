package com.serdarsenturk;

public class LongTimeMovie extends Movie {
    private int timeLength;
    private String title;

    public LongTimeMovie(int id, String originalTitle, Genre genre, int timeLength, String title){
        super(id, originalTitle, genre, title);
        this.timeLength = timeLength;
    }

    public int getTimeLength(){
        return this.timeLength;
    }

    public String getTitle(){
        return this.title;
    }
}
