package com.serdarsenturk;

public class LongTimeMovie extends Movie {
    private int timeLength;
    private String title;

    public LongTimeMovie(int id, String originalTitle, int timeLength, String title, Genre genre){
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
