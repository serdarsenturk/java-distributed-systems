package com.serdarsenturk;

import java.security.KeyException;
import java.util.*;

public class Movie{

    private String name;
    private int price;
    private HashMap<Integer, Comment> comments;
    private Genre genre;

    public Movie(String name, Genre genre){
        this.name = name;
        this.genre = genre;
        this.comments = new HashMap<>();
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
        var commentsDictValues = this.comments.values();
        var commentArray = new ArrayList<>(commentsDictValues);

        return commentArray;
    }

    public void addComment(Comment comment) throws KeyException {
        if(this.comments.containsKey(comment.getId())){
            throw new KeyException("Key zaten var");
        }

        this.comments.put(comment.getId(), comment);
    }

    public void updateComment(Comment comment) throws KeyException {
        if(!this.comments.containsKey(comment.getId())){
            throw new KeyException("Key yok");
        }

        this.comments.put(comment.getId(), comment);
    }

    public void setPrice(int price){
        this.price = price;
    }

    public int getNextMinimumPrice(){
        return this.price + this.price * 10 / 100;
    }
}
