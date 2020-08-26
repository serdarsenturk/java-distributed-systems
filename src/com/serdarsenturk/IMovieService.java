package com.serdarsenturk;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

public interface IMovieService extends IReadService, IWriteService {
    MovieEntity getById(int id) throws IOException, URISyntaxException;
    void create(MovieEntity movie);
}
