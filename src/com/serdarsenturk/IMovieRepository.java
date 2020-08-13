package com.serdarsenturk;

import java.sql.SQLException;

public interface IMovieRepository {
    public void create(Movie movie) throws SQLException;
    public Movie getById(int id) throws SQLException;
}
