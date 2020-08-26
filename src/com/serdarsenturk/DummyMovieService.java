package com.serdarsenturk;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;

public class DummyMovieService implements IMovieService{

    // TheMovieDb api_key
    final String api_key = "1412bb0910c171bc419e90e2f68f47e6" ;

    public MovieEntity getById(int id) throws MalformedURLException, URISyntaxException {

        //Convert to int to string
        var nid = Integer.toString(id);

        //General urlbuilder and it depends id
        URLBuilder urlb = new URLBuilder("api.themoviedb.org");
        urlb.setConnectionType("https");
        urlb.addSubfolder("3");
        urlb.addSubfolder("tv");
        urlb.addSubfolder(nid);
        urlb.addSubfolder("season");
        urlb.addSubfolder("1");
        urlb.addParameter("api_key", api_key);
        urlb.addParameter("language", "en-US");

        String url = urlb.getURL();
//        System.out.println("Current adress: " + url );

        // Split the url and check if it contains movie
        String[] params = url.split("/");
        boolean contains = Arrays.asList(params).contains("movie");

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest req = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        //thenApply vs thenAccept
        //.join?
        // Asynchronous

        var movieDTO = client.sendAsync(req, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenApply(response -> {
                    ObjectMapper objectMapper = new ObjectMapper()
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

        try{
            if(contains) {
                return new MoviesEntity(movieDTO.getId(), "a", movieDTO.getTitle(), "Action", movieDTO.getOriginalLanguage(), movieDTO.getVoteAverage(), movieDTO.getRuntime(), movieDTO.getRevenue());
            }
            else{
                return new TvShowsEntity(movieDTO.getId(), "b", movieDTO.getTitle(), "Action", movieDTO.getOriginalLanguage(), movieDTO.getVoteAverage(),  movieDTO.getNumberOfSeasons(), movieDTO.getNumberOfSeasons(), movieDTO.getEpisodeRunTime());
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public void create(MovieEntity movie) {
        System.out.println("X movie created");
    }

}