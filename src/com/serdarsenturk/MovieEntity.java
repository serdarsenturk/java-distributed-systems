package com.serdarsenturk;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "movie", schema = "Movies", catalog = "")
public class MovieEntity {
    private Integer id;
    private String originalTitle;
    private String title;
    private String genre;
    private Integer movieType;

    @Id
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "originalTitle", nullable = true, length = -1)
    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    @Basic
    @Column(name = "title", nullable = true, length = -1)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "genre", nullable = true, length = -1)
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Basic
    @Column(name = "movieType", nullable = true)
    public Integer getMovieType() {
        return movieType;
    }

    public void setMovieType(Integer movieType) {
        this.movieType = movieType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovieEntity that = (MovieEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(originalTitle, that.originalTitle) &&
                Objects.equals(title, that.title) &&
                Objects.equals(genre, that.genre) &&
                Objects.equals(movieType, that.movieType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, originalTitle, title, genre, movieType);
    }
}
