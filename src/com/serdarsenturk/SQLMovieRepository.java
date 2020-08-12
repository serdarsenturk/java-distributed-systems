package com.serdarsenturk;

import java.sql.*;

public class SQLMovieRepository implements IMovieRepository {
    static final String DB_URL = "jdbc:mysql://localhost/Movies";

    static final String USER = "root";
    static final String PASS = "Unviserded1*";


    @Override
    public void create(Movie movie) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Connecting to a selected database...");

            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");

            System.out.println("Inserting records into the table...");

            String insertQuery = "INSERT INTO movie (id, originalTitle, title, genre) VALUES (?, ?, ?, ?)";

            pstmt = conn.prepareStatement(insertQuery);

            pstmt.setInt(1, movie.getId());
            pstmt.setString(2, movie.getOriginalTitle());
            pstmt.setString(3, movie.getTitle());
            pstmt.setObject(4, movie.getGenre().name());

            pstmt.execute();

            if (movie instanceof ShortMovie) {
                String shortMovieQuery = "INSERT INTO short_movie (runtime) VALUES (?, ?)";
                pstmt = conn.prepareStatement(shortMovieQuery);

                pstmt.setInt(1, movie.getId());
                pstmt.setInt(2, ((ShortMovie) movie).getRuntime());

                pstmt.execute();
                System.out.println("Inserted records into the table...");
            }
            if (movie instanceof SeriesMovie) {
                String seriesMovieQuery = "INSERT INTO series_movie (episodes, seasons) VALUES (?, ?)";
                pstmt = conn.prepareStatement(seriesMovieQuery);

                pstmt.setInt(1, ((SeriesMovie) movie).getEpisodes());
                pstmt.setInt(2, ((SeriesMovie) movie).getSeasons());

                pstmt.execute();
                System.out.println("Inserted records into the table...");
            }
            if (movie instanceof LongTimeMovie) {
                String longTimeMovieQuery = "INSERT INTO long_time_movie (timeLenght) VALUES (?)";

                pstmt = conn.prepareStatement(longTimeMovieQuery);

                pstmt.setInt(1, ((LongTimeMovie) movie).getTimeLength());

                pstmt.execute();
                System.out.println("Inserted records into the table...");
            }

        } catch (Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (pstmt != null)
                    conn.close();
            } catch (SQLException se) {
            }// do nothing
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }   //end finally try
        }   //end try
    }

    @Override
    public Movie getById(int id) {
        Connection conn = null;
        Statement stmt = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Connecting to a selected database...");

            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");

            System.out.println("Fetching details from database...");

            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

            //ResultSet rs = stmt.executeQuery("SELECT * FROM movie WHERE id = '" + id +"'"); // olusturulan baglanti ifadesini result set olarak tanimladik
            ResultSet rs = stmt.executeQuery(
                    "SELECT m.id, m.originalTitle, m.title, m.genre,  m.movieType, sm.runtime, srm.seasons, srm.episodes, ltm.timeLenght " +
                            "FROM movie AS m " +
                            "LEFT JOIN short_movie AS sm ON m.id = sm.id " +
                            "LEFT JOIN series_movie AS srm ON m.id = srm.id " +
                            "LEFT JOIN long_time_movie AS ltm ON srm.id = ltm.id " +
                            "WHERE m.id = " + id);

            while (rs.next()) {
                int idM = rs.getInt("id");
                String originalTitleM = rs.getString("originalTitle");
                String titleM = rs.getString("title");
                String genreM= rs.getString("genre");
                int movieTypeM = rs.getInt("movieType");
                int runtimeM = rs.getInt("runtime");
                int seasonsM = rs.getInt("seasons");
                int episodesM = rs.getInt("episodes");
                int timeLenghtM = rs.getInt("timeLenght");

                if ( movieTypeM == 0) {
                    return new ShortMovie(idM, originalTitleM, titleM, Genre.Thriller, runtimeM);
                }
                else if (movieTypeM == 1) {
                    return new LongTimeMovie(idM, originalTitleM, titleM, Genre.Thriller, timeLenghtM);
                }
                else if (movieTypeM == 2) {
                    return new SeriesMovie(idM, originalTitleM, titleM, Genre.Thriller, seasonsM, episodesM);
                }
            }


        }//end try
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}