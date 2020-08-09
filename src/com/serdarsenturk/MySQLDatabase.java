package com.serdarsenturk;
import java.sql.*;
import java.util.ArrayList;

public class MySQLDatabase implements IDatabase {
    static final String DB_URL = "jdbc:mysql://localhost/Movies";

    static final String USER = "root";
    static final String PASS = "Unviserded1*";

    @Override
    public void readFromDatabase() {
        Connection conn = null;
        Statement stmt = null;

        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Connecting to a selected database...");

            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");

            System.out.println("Taking short_movie table from database...");

            stmt = conn.createStatement();

            String sql = ("SELECT * FROM short_movie");

            stmt.executeQuery(sql);
            System.out.println("Listed table in given database");

        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    conn.close();
            }catch(SQLException se){
            }// do nothing
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
    }

    @Override
    public void writeToDatabase(Movie movie) {
        Connection conn = null;
        Statement stmt = null;

        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Connecting to a selected database...");

            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");

            System.out.println("Inserting records into the table...");

            String insertQuery = "INSERT INTO movie (id, originalTitle, title, genre) VALUES (?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(insertQuery);
            pstmt.setInt(1, movie.getId());
            pstmt.setString(2, movie.getOriginalTitle());
            pstmt.setString(3, movie.getTitle());
            pstmt.setObject(4, movie.getGenre().name());

            pstmt.execute();
            System.out.println("Inserted records into the table...");

        }catch(Exception e){
            // Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    conn.close();
            }catch(SQLException se){
            }// do nothing
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }   //end finally try
        }   //end try
    }
}
