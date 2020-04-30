package com.serdarsenturk;

public interface IMovieService {
    Iterable<Movie> getAll();
    Movie getById(int id);
    void deleteById(int id);
    void Create(Movie movie);
}
