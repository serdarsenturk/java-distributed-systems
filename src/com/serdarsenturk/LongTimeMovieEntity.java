package com.serdarsenturk;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="long_time_movie")
@PrimaryKeyJoinColumn(name="id")
public class LongTimeMovieEntity extends MovieEntity{
//    private Integer id;
    private Integer timeLenght;

    public LongTimeMovieEntity(){}

    public LongTimeMovieEntity(Integer id, String originalTitle, String title, String genre, Integer timeLenght){
        super(id, originalTitle, title, genre);
        this.timeLenght = timeLenght;
    }

    @Column(name = "timeLenght", nullable = true)
    public Integer getTimeLenght() {
        return timeLenght;
    }

    public void setTimeLenght(Integer timeLenght) {
        this.timeLenght = timeLenght;
    }

}