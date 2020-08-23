package com.serdarsenturk;

import java.io.IOException;
import java.net.MalformedURLException;

public interface IMovieService extends IReadService, IWriteService {
    MovieEntity getById(int id) throws IOException;
    void create(MovieEntity movie);
}
