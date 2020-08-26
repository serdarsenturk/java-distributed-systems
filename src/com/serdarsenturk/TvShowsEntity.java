package com.serdarsenturk;

import javax.persistence.*;

@Entity
@Table(name="tv_shows")
@PrimaryKeyJoinColumn(name="id")
public class TvShowsEntity extends MovieEntity {
    private Integer seasons;
    private Integer episodes;
    private Integer episodesRuntime;

    public TvShowsEntity(){}

    public TvShowsEntity(Integer id, String originalTitle, String title, String genre, String originalLanguage, Float voteAverage, Integer seasons, Integer episodes, Integer episodesRuntime){
        super(id, originalTitle, title, genre, originalLanguage, voteAverage);
        this.seasons = seasons;
        this.episodes = episodes;
        this.episodesRuntime = episodesRuntime;
    }

    @Override
    public String getTitle() {
        return "TvShow";
    }

    @Column(name = "seasons", nullable = true)
    public Integer getSeasons() {
        return seasons;
    }

    public void setSeasons(Integer seasons) {
        this.seasons = seasons;
    }

    @Column(name = "episodes", nullable = true)
    public Integer getEpisodes() {
        return episodes;
    }

    public void setEpisodes(Integer episodes) {
        this.episodes = episodes;
    }

    @Column(name = "episodesRuntime")
    public Integer getEpisodesRuntime(){return episodesRuntime;}

    public void setEpisodesRuntime(Integer episodesRuntime){this.episodesRuntime = episodesRuntime;}
}