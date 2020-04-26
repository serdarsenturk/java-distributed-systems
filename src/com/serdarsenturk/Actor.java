package com.serdarsenturk;

import java.util.HashMap;

public class Actor {
    private int actorId;
    private String name;
    private int age;

    public Actor(int actorId, String name, int age){
        this.actorId = actorId;
        this.name = name;
        this.age = age;
    }

    public String getName(){
        return this.name;
    }

    public int getAge(){
        return this.age;
    }

    public int getActorId(){
        return this.actorId;
    }
}
