package com.serdarsenturk;

import java.sql.SQLException;

public interface IMovieRepository {
    public void create(MovieEntity movie);
    public MovieEntity getById(int id);
}
