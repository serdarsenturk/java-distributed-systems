package com.serdarsenturk;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="series_movie")
@PrimaryKeyJoinColumn(name="id")
public class TvShowsEntity extends MovieEntity {
    private Integer seasons;
    private Integer episodes;

    public TvShowsEntity(){}

    public TvShowsEntity(Integer id, String originalTitle, String title, String genre, Integer seasons, Integer episodes){
        super(id, originalTitle, title, genre);
        this.seasons = seasons;
        this.episodes = episodes;
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

}