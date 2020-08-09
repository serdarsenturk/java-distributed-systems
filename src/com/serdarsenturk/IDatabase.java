package com.serdarsenturk;

public interface IDatabase {
    void readFromDatabase();
    void writeToDatabase(Movie movie);
}
