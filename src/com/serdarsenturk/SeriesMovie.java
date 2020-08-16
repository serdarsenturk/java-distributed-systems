package com.serdarsenturk;

import java.security.KeyException;
import java.util.HashMap;

public class SeriesMovie extends Movie {
    private int seasons;
    private int episodes;
    private String title;

    public  SeriesMovie(int id, String originalTitle, String title, Genre genre, int seasons, int episodes){
        super(id, originalTitle, title, genre);
        this.episodes = episodes;
        this.seasons = seasons;
    }

    public int getSeasons(){
        return this.seasons;
    }

    public void setSeasons(int seasons){
        this.seasons = seasons;
    }

    public int getEpisodes(){return this.episodes;}
    public void setEpisodes(int episodes){
        this.episodes = episodes;
    }

    public String getTitle(){
        return "Series Film" + this.title;
    }

    @Override
    public void addActor(Actor actor) throws KeyException {
        if(isActorExists(actor)){
            System.out.println("Actor with name: " + actor.getActorName() + " is added to SeriesMovie");
        }

        super.addActor(actor);
    }
}