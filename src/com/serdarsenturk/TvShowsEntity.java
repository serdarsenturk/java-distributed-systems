package com.serdarsenturk;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="tv_shows")
@PrimaryKeyJoinColumn(name="id")
public class TvShowsEntity extends MovieEntity {
    private Integer seasons;
    private Integer episodes;
    private Integer episodesRuntime;

    public TvShowsEntity(){}

    public TvShowsEntity(Integer id, String originalTitle, String title, String genre, Integer seasons, Integer episodes, Integer episodesRuntime){
        super(id, originalTitle, title, genre);
        this.seasons = seasons;
        this.episodes = episodes;
        this.episodesRuntime = episodesRuntime;
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

    @Column(name = "episodesRuntime", nullable = true)
    public Integer getEpisodesRuntime(){return episodesRuntime;}

    public void setEpisodesRuntime(Integer episodesRuntime){this.episodesRuntime = episodesRuntime;}
}