package com.serdarsenturk;

public interface IReadService extends IMovieRepository {
    abstract MovieEntity getById(int id);
}
