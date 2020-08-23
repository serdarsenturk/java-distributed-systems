package com.serdarsenturk;

import java.io.IOException;
import java.net.MalformedURLException;

public interface IReadService extends IMovieRepository {
    abstract MovieEntity getById(int id) throws IOException;
}
