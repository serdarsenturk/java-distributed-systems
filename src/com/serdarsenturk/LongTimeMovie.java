package com.serdarsenturk;

public class LongTimeMovie extends Movie {
    private int timeLength;
    private String title;

    public LongTimeMovie(int id, String name, Genre genre, int timeLength, String title, String author){
        super(id, name, genre, title, author);
        this.timeLength = timeLength;
    }

    public int getTimeLength(){
        return this.timeLength;
    }

    public String getTitle(){
        return this.title;
    }
}
