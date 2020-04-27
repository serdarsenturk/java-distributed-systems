package com.serdarsenturk;

public class LongTimeMovie extends Movie {
    private int timeLength;

    public LongTimeMovie(int id, String name, Genre genre, int timeLength){
        super(id, name, genre);
        this.timeLength = timeLength;
    }

    public int getTimeLength(){
        return this.timeLength;
    }
}
