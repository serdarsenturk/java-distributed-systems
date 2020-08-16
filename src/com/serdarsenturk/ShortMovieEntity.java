package com.serdarsenturk;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "short_movie", schema = "Movies", catalog = "")
public class ShortMovieEntity {
    private Integer id;
    private Integer runtime;

    @Id
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
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
