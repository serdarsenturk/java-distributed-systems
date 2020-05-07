package com.serdarsenturk;

public class MovieDTO {
    private int id;
    private int popularity;
    private String originalTitle;
    private String title;
    private int runtime;

    public void setId(int id){this.id = id;}

    public int getId(){return this.id;}

    public void setPopularity(int popularity){
        this.popularity = popularity;
    }

    public int getPopularity(){
        return this.popularity;
    }

    public void setOriginalTitle(String originalTitle){
        this.originalTitle = originalTitle;
    }

    public String getOriginalTitle(){
        return this.originalTitle;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getTitle(){
        return this.title;
    }

    public void setRuntime(int runtime){
        this.runtime = runtime;
    }

    public int getRuntime(){
        return this.runtime;
    }

}
