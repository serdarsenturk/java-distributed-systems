package com.serdarsenturk;
import java.util.Date;
public class Comment {
    private int id;
    private Date createdDate;
    private int userId;
    private String comment;
    public Comment(int id, String comment, int userId, Date createdDate){
        this.id = id;
        this.comment = comment;
        this.userId = userId;
        this.createdDate = createdDate;
    }
    public int getId(){
        return this.id;
    }
    public String getComment(){
        return this.comment;
    }
    public int getUserId(){
        return this.userId;
    }
    public Date getCreatedDate(){
        return this.createdDate;
    }
}