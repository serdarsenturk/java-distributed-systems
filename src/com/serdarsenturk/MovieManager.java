package com.serdarsenturk;

public class MovieManager {
    public void addMovie(IDatabase database, Movie movie){
        database.writeToDatabase(movie);
    }
}
