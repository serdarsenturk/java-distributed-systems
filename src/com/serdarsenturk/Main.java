package com.serdarsenturk;
import com.serdarsenturk.Movie;

import java.security.KeyException;
import java.util.*;
public class Main {

    public static void main(String[] args) {

        var movie1 = new Movie("A", Genre.Action);
        var actor1 = new Actor(1, "Serdar", 22);
        var actor2 = new Actor(2, "Engin", 31);

        try {
            movie1.addActor(actor1);
            movie1.addActor(actor2);
            actor1.addMovies(movie1);
            actor2.addMovies(movie1);
        }
        catch (KeyException ex){
            System.out.println(ex.getMessage());
        }
/*
        var myMovie = new Movie("Engin", Genre.Action);


        myMovie.setPrice(100);
        try {
            myMovie.addComment(new Comment(1, "A", 101, new Date()));
            myMovie.addComment(new Comment(2, "B", 102, new Date()));
            myMovie.addComment(new Comment(3, "C", 103, new Date()));
            myMovie.addComment(new Comment(4, "D", 104, new Date()));
            myMovie.updateComment(new Comment(2, "K", 105, new Date()));
            myMovie.addActor(new Actor(900, "Serdar", 22));


        }
        catch (KeyException ex) {
            System.out.println(ex.getMessage());
        }

        //System.out.println(myMovie.getComments("A"));
        System.out.println(myMovie.getName());
        System.out.println("Comment count: " + myMovie.getCommentSize());


        for(var comment : myMovie.getComments()){
            System.out.println("Comment Id: " + comment.getId());
            System.out.println("Comment Text: " + comment.getComment());
            System.out.println("Comment User: " + comment.getUserId());
            System.out.println("Comment Date: " + comment.getCreatedDate());
        }

        for(var actor : myMovie.getActors()){
            System.out.println("Actor Id: " + actor.getActorId());
            System.out.println("Actor Name: " + actor.getName());
            System.out.println("Actor Age: " + actor.getAge());

        }
        System.out.println(Genre.Action.ordinal());
*/
//        Movie t1 = new Movie();
//
//        List<String> actors1 = new ArrayList();
//
//        actors1.add("A");
//        actors1.add("B");
//        actors1.add("C");
    }
//    t1.setActors(actors1);
}