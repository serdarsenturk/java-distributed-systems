package com.serdarsenturk;

import java.io.IOException;

public interface IMovieService extends IReadService, IWriteService {
    MovieEntity getById(int id);
    void Create(MovieEntity movie);
}
