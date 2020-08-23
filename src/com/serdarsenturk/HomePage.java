package com.serdarsenturk;

public class HomePage {

    public static void movieDetails(int id){
        System.out.println("Welcome to MovieDb");
        var movie = new DummyMovieService();
        movie.getById(id);
    }

    public static void addComment(int id){

    }
}
