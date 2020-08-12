package com.serdarsenturk;

public interface IMovieRepository {
    public void create(Movie movie);
    public Movie getById(int id);
}
