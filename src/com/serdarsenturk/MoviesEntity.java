package com.serdarsenturk;

import org.hibernate.mapping.List;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="movies")
@PrimaryKeyJoinColumn(name="id")
public class MoviesEntity extends MovieEntity {
    private Integer runtime;
    private Integer revenue;


    public MoviesEntity(){}

    public MoviesEntity(Integer id, String originalTitle, String title, String genre, Integer runtime, Integer revenue){
        super(id, originalTitle, title, genre);
        this.runtime = runtime;
        this.revenue = revenue;
    }

    @Column(name = "runtime", nullable = true)
    public Integer getRuntime() {
        return runtime;
    }

    public void setRuntime(Integer runtime) {
        this.runtime = runtime;
    }

    @Column(name = "revenue", nullable = true)
    public Integer getRevenue() {
        return revenue;
    }

    public void setRevenue(Integer revenue) {
        this.revenue = revenue;
    }
}