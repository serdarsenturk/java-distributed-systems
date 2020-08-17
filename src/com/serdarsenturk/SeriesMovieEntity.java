package com.serdarsenturk;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "series_movie", schema = "Movies", catalog = "")
public class SeriesMovieEntity {
    private Integer id;
    private Integer seasons;
    private Integer episodes;

    @Id
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public MovieEntity getMovieEntity() {
        return movieEntity;
    }

    public void setMovieEntity(MovieEntity movieEntity) {
        this.movieEntity = movieEntity;
    }

    @OneToOne
    @JoinColumn(name = "id")
    @MapsId
    private MovieEntity movieEntity;

    @Basic
    @Column(name = "seasons", nullable = true)
    public Integer getSeasons() {
        return seasons;
    }

    public void setSeasons(Integer seasons) {
        this.seasons = seasons;
    }

    @Basic
    @Column(name = "episodes", nullable = true)
    public Integer getEpisodes() {
        return episodes;
    }

    public void setEpisodes(Integer episodes) {
        this.episodes = episodes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SeriesMovieEntity that = (SeriesMovieEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(seasons, that.seasons) &&
                Objects.equals(episodes, that.episodes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, seasons, episodes);
    }
}