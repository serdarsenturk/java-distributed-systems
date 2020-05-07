package com.serdarsenturk;

import java.io.IOException;

public interface IMovieService {
    Iterable<Movie> getAll() throws IOException, InterruptedException;
    Movie getById(int id);
    void deleteById(int id);
    void Create(Movie movie);
}
