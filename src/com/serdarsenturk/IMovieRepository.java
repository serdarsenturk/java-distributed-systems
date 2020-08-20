package com.serdarsenturk;

import java.sql.SQLException;

public interface IMovieRepository {
    public void create(MovieEntity movie) throws SQLException;
    public MovieEntity getById(int id) throws SQLException;
}
