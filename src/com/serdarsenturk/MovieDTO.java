package com.serdarsenturk;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MovieDTO {

    private int id;
    private String originalName;
    private int popularity;
    private String originalTitle;
    private String title;
    private int runtime;
    private int revenue;
    private int episodeRunTime;
    private int numberOfEpisodes;
    private int numberOfSeasons;
    private String originalLanguage;
    private Float voteAverage;

    public String getOriginalName(){
        return this.originalName;
    }

    public int getEpisodeRunTime() {
        return this.episodeRunTime;
    }

    public int getNumberOfEpisodes() {
        return this.numberOfEpisodes;
    }

    public int getNumberOfSeasons() {
        return this.numberOfSeasons;
    }

    public int getId(){return this.id;}

    public int getPopularity(){
        return this.popularity;
    }

    public String getOriginalTitle(){
        return this.originalTitle;
    }

    public String getTitle(){
        return this.title;
    }

    public int getRuntime(){
        return this.runtime;
    }

    public int getRevenue(){
        return this.revenue;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public Float getVoteAverage() {
        return voteAverage;
    }

}
