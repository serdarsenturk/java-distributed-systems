package com.serdarsenturk;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

public class DummyMovieService implements IMovieService {


    public Iterable<Movie> getAll() {

        return new ArrayList<>();
    }

    public Movie getById(int id) {

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest req = HttpRequest.newBuilder()
                .uri(URI.create("https://api.themoviedb.org/3/movie/550"))
                .header("Authorization", "")
                .header("content-type", "application/json;charset=utf-8")
                .build();

        //thenApply vs thenAccept
        //.join?
        // Asynchronous
        var movieDTO = client.sendAsync(req, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenApply(response -> {

                    var objectMapper = new ObjectMapper()
                            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                            .setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);

                    try {
                        return objectMapper.readValue(response, MovieDTO.class);
                    } catch (JsonProcessingException e) {
                        e.printStackTrace();
                        return null;
                    }

                })
                .join();

        System.out.println("Movie name: " + movieDTO.getId());
        System.out.println("Movie name: " + movieDTO.getOriginalTitle());
        System.out.println("Movie name: " + movieDTO.getPopularity());
        System.out.println("Movie name: " + movieDTO.getTitle());
        System.out.println("Movie name: " + movieDTO.getRuntime());
        return new ShortMovie(movieDTO.getId(), movieDTO.getOriginalTitle(), Genre.Horror, movieDTO.getTitle(), movieDTO.getRuntime());
    }

    public void deleteById(int id) {
        System.out.println("X movie deleted");
    }

    public void Create(Movie movie) {
        System.out.println("X movie created");
    }
}
