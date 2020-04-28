package com.serdarsenturk;

import java.util.HashMap;

public class SeriesMovie extends Movie {
    private int seasons;
    private int episodes;

    public  SeriesMovie(int id, String name, Genre genre, int seasons, int episodes){
        super(id, name, genre);
        this.episodes = episodes;
        this.seasons = seasons;
    }

    public int getSeasons(){
        return this.seasons;
    }
    public int getEpisodes(){return this.episodes;}
}
