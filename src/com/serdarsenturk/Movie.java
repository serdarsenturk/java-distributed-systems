package com.serdarsenturk;

import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;

public class Movie{

    private String name;
    private int price;
    private Hashtable<Integer, ArrayList<comment>> comments;
    private Genre genre;

    public Movie(String name, Genre genre){
        this.name = name;
        this.genre = genre;
        this.comments = new Hashtable<Integer, ArrayList<comment>>();
    }
    public String getName(){
        return this.name;
    }
    public int getPrice(){
        return price;
    }
    public int getCommentSize(){
        return this.comments.size();
    }
    public Iterable<Comment> getComments(){
        return this.comments;
    }
    public void setPrice(int price){
        this.price = price;
    }
    public int getNextMinimumPrice(){
        return this.price + this.price * 10 / 100;
    }
    public void addComment(int id, String commentText, int userId){
        var comment = new Comment(id, commentText, userId, new Date());

        this.comments;
    }
}
