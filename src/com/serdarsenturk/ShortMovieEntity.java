package com.serdarsenturk;

import org.hibernate.mapping.List;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "short_movie", schema = "Movies", catalog = "")
public class ShortMovieEntity extends MovieEntity {
    private Integer id;
    private Integer runtime;

    public ShortMovieEntity(){}

    public ShortMovieEntity(Integer id, String originalTitle, String title, String genre, Integer runtime){
        super(id, originalTitle, title, genre);
        this.runtime = runtime;
    }

    @Id
    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
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


    @Column(name = "runtime", nullable = true)
    public Integer getRuntime() {
        return runtime;
    }

    public void setRuntime(Integer runtime) {
        this.runtime = runtime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShortMovieEntity that = (ShortMovieEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(runtime, that.runtime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, runtime);
    }
}