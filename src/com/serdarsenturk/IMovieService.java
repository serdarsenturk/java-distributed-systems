package com.serdarsenturk;

import java.io.IOException;

public interface IMovieService extends IReadService, IWriteService {
    Movie getById(int id);
    void Create(Movie movie);
}
