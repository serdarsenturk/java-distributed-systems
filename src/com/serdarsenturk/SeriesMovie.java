package com.serdarsenturk;

public class SeriesMovie extends Movie {
    private int seasonNumber;

    public  SeriesMovie(int id, String name, Genre genre, int seasonNumber){
        super(id, name, genre);
        this.seasonNumber = seasonNumber;
    }

    public int getSeasonNumber(){
        return this.seasonNumber;
    }
}
