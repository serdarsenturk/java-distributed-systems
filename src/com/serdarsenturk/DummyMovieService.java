package com.serdarsenturk;

import java.util.ArrayList;

public class DummyMovieService implements IMovieService {

    @Override
    public Iterable<Movie> getAll() {
        return new ArrayList<>();
    }

    @Override
    public Movie getById(int id) {
        var movie = new ShortMovie(1000, "Black", Genre.Horror, "So drill", "Jamie", 75);
        return movie;
    }

    @Override
    public void deleteById(int id) {
        System.out.println("X movie deleted");
    }

    @Override
    public void Create(Movie movie) {
        System.out.println("X movie created");
    }
}
