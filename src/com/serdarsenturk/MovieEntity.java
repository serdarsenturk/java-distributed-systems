package com.serdarsenturk;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "movie")
@Inheritance(strategy=InheritanceType.JOINED)
public class MovieEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private String originalTitle;
    private String title;
    private String genre;
    private Integer movieType;

    public MovieEntity(){}

    public MovieEntity(Integer id, String originalTitle, String title, String genre){
        this.id = id;
        this.originalTitle = originalTitle;
        this.title = title;
        this.genre = genre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "originalTitle", nullable = true, length = -1)
    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    @Column(name = "title", nullable = true, length = -1)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "genre", nullable = true, length = -1)
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Column(name = "movieType", nullable = true)
    public Integer getMovieType() {
        return movieType;
    }

    public void setMovieType(Integer movieType) {
        this.movieType = movieType;
    }

    public static void addActor(Actor actor) {
    }

}