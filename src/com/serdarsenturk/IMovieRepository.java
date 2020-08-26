package com.serdarsenturk;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.sql.SQLException;

public interface IMovieRepository {
    public void create(MovieEntity movie);
    public MovieEntity getById(int id) throws IOException, URISyntaxException;
}
