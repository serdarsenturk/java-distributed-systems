package com.serdarsenturk;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.serdarsenturk.Movie;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.security.KeyException;
public class Main {

    public static void main(String[] args) {
/*
        var actor1 = new Actor(1, "Serdar", 22);
        var actor2 = new Actor(2, "Engin", 31);
        var actor3 = new Actor(3, "Görkem", 21);
        var movie2 = new ShortMovie(101, "B", Genre.Fiction, "XB", "YB",  70);

        var movie3 = new LongTimeMovie(102, "C", Genre.Action, 120, "XC", "YC");
        var movie4 = new SeriesMovie(103, "D", Genre.Horror, 5, 12, "XD", "YD");
        try {
            movie3.addActor(actor3);
            movie4.addActor(actor1);
            movie2.addActor(actor1);
            movie2.addCompetition("K");
            movie2.addCompetition("M");
        }
        catch (KeyException ex){
            System.out.println(ex.getMessage());
        }
*/

        var movie6 = new DummyMovieService();
//        movie6.getAll();
        movie6.getById(550);
//        movie6.deleteById(102);
//        movie6.Create(new SeriesMovie(5000, "Black", Genre.Action, 3, 10, "Super", "Brain Connor"));


    }
}

