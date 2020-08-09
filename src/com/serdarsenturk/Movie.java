package com.serdarsenturk;

import java.security.KeyException;
import java.util.*;

public abstract class Movie{
    private int id;
    private String originalTitle;
    private int budget;
    private HashMap<Integer, Comment> comments;
    private HashMap<Integer, Actor> actors;
    private Genre genre;
    private String author;
    private String title;

    public Movie(int id, String originalTitle, String title , Genre genre){
        this.id = id;
        this.originalTitle = originalTitle;
        this.genre = genre;
        this.title = title;
        this.comments = new HashMap<>();
        this.actors = new HashMap<>();
    }

    public int getId(){
        return this.id;
    }

    public String getOriginalTitle(){
        return this.originalTitle;
    }

    public int getBudget(){
        return this.budget;
    }

    public String getAuthor(){
        return this.author;
    }

    public int getCommentSize(){
        return this.comments.size();
    }

    public Iterable<Comment> getComments(){
        var commentsDictValues = this.comments.values();
        return new ArrayList<>(commentsDictValues);
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
    public Iterable<Actor> getActors(){
        var actorsDictValues = this.actors.values();
        return new ArrayList<>(actorsDictValues);
    }

    public void addActor(Actor actor) throws KeyException {
        if(isActorExists(actor)){
            return;
        }

        this.actors.put(actor.getId(), actor);
        actor.addMovies(this);
    }

    protected Boolean isActorExists(Actor actor){
        return this.actors.containsKey(actor.getId());
    }

    public String getTitle(){
        return this.title;
    }

    public void setBudget(int budget){
        this.budget = budget;
    }

    public int getNextMinimumBudget(){
        return this.budget + this.budget * 10 / 100;
    }

    public void setGenre(Genre genre){
        this.genre = genre;
    }
    public Genre getGenre(){
        return this.genre;
    }
}
