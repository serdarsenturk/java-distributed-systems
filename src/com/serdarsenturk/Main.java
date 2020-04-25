package com.serdarsenturk;
import com.serdarsenturk.Movie;
import java.util.*;
public class Main {

    public static void main(String[] args) {
        var myMovie = new Movie("Engin", Genre.Action);

        myMovie.setPrice(100);

        myMovie.addComment(1, "First comment", 123);
        myMovie.addComment(2, "Second comment", 124);
        System.out.println(myMovie.getName());
        System.out.println("Comment count: " + myMovie.getCommentSize());
        for(var comment : myMovie.getComments()){
            System.out.println("Comment Id: " + comment.getId());
            System.out.println("Comment Text: " + comment.getComment());
            System.out.println("Comment User: " + comment.getUserId());
            System.out.println("Comment Date: " + comment.getCreatedDate());
        }
        System.out.println(Genre.Action.ordinal());
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