package com.serdarsenturk;

public interface IWriteService extends IMovieRepository {
    abstract void create(MovieEntity movie);
}
