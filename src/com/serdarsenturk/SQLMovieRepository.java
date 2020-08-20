//package com.serdarsenturk;
//
//import java.sql.*;
//
//public class SQLMovieRepository implements IMovieRepository {
//    static final String DB_URL = "jdbc:mysql://localhost/Movies";
//
//    static final String USER = "root";
//    static final String PASS = "Unviserded1*";
//
//
//    @Override
//    public void create(MovieEntity movie) throws SQLException {
//        Connection conn = null;
//        PreparedStatement pstmt = null;
//
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            System.out.println("Connecting to a selected database...");
//
//            conn = DriverManager.getConnection(DB_URL, USER, PASS);
//
//            conn.setAutoCommit(false);
//
//            System.out.println("Connected database successfully...");
//
//            System.out.println("Inserting records into the table...");
//
//            String insertQuery = "INSERT INTO movie (id, originalTitle, title, genre, movieType) VALUES (?, ?, ?, ?, ?)";
//
//            pstmt = conn.prepareStatement(insertQuery);
//
//            pstmt.setInt(1, movie.getId());
//            pstmt.setString(2, movie.getOriginalTitle());
//            pstmt.setString(3, movie.getTitle());
//            pstmt.setObject(4, movie.getGenre());
//            pstmt.setInt(5, 2);
//
//            pstmt.execute();
//
//            if (movie instanceof ShortMovieEntity) {
//                String shortMovieQuery = "INSERT INTO short_movie (id, runtime) VALUES (?, ?)";
//                pstmt = conn.prepareStatement(shortMovieQuery);
//
//                pstmt.setInt(1, movie.getId());
//                pstmt.setInt(2, ((ShortMovieEntity) movie).getRuntime());
//
//                pstmt.execute();
//
//                System.out.println("Inserted records into the table...");
//            }
//            if (movie instanceof SeriesMovieEntity) {
//                String seriesMovieQuery = "INSERT INTO series_movie (id, episodes, seasons) VALUES (?, ?, ?)";
//                pstmt = conn.prepareStatement(seriesMovieQuery);
//
//                pstmt.setInt(1, movie.getId());
//                pstmt.setInt(2, ((SeriesMovieEntity) movie).getEpisodes());
//                pstmt.setInt(3, ((SeriesMovieEntity) movie).getSeasons());
//
//                pstmt.execute();
//
//                //conn.commit(); // Committing data here
//                System.out.println("Inserted records into the table...");
//            }
//            if (movie instanceof LongTimeMovieEntity) {
//                String longTimeMovieQuery = "INSERT INTO long_time_movie (timeLenght) VALUES (?)";
//
//                pstmt = conn.prepareStatement(longTimeMovieQuery);
//
//                pstmt.setInt(1, ((LongTimeMovieEntity) movie).getTimeLength());
//
//                pstmt.execute();
//
//                System.out.println("Inserted records into the table...");
//            }
//            conn.commit(); // Committing data here
//
//        } catch(SQLException se){
//            // If there is any error.
//            se.printStackTrace();
//            conn.rollback();
//        } catch (Exception e) {
//            // Handle errors for Class.forName
//            e.printStackTrace();
//        } finally {
//            //finally block used to close resources
//            try {
//                if (pstmt != null)
//                    pstmt.close();
//            } catch (SQLException se) {
//            }// do nothing
//            try {
//                if (conn != null)
//                    conn.close();
//            } catch (SQLException se) {
//                se.printStackTrace();
//            }   //end finally try
//        }   //end try
//    }
//
//    @Override
//    public MovieEntity getById(int id) throws SQLException {
//        Connection conn = null;
//        Statement stmt = null;
//
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            System.out.println("Connecting to a selected database...");
//
//            conn = DriverManager.getConnection(DB_URL, USER, PASS);
//            System.out.println("Connected database successfully...");
//
//            conn.setAutoCommit(false); // we turn-off auto-commit
//
//            System.out.println("Fetching details from database...");
//
//            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
//
//            ResultSet rs = stmt.executeQuery(
//                    "SELECT m.id, m.originalTitle, m.title, m.genre,  m.movieType, sm.runtime, srm.seasons, srm.episodes, ltm.timeLenght " +
//                            "FROM movie AS m " +
//                            "LEFT JOIN short_movie AS sm ON m.id = sm.id " +
//                            "LEFT JOIN series_movie AS srm ON m.id = srm.id " +
//                            "LEFT JOIN long_time_movie AS ltm ON srm.id = ltm.id " +
//                            "WHERE m.id = " + id);
//
//            while (rs.next()) {
//                int idM = rs.getInt("id");
//                String originalTitleM = rs.getString("originalTitle");
//                String titleM = rs.getString("title");
//                String genreM= rs.getString("genre");
//                int movieTypeM = rs.getInt("movieType");
//                int runtimeM = rs.getInt("runtime");
//                int seasonsM = rs.getInt("seasons");
//                int episodesM = rs.getInt("episodes");
//                int timeLenghtM = rs.getInt("timeLenght");
//
//                if ( movieTypeM == 0) {
//                    return new ShortMovieEntity(idM, originalTitleM, titleM, "Korku", runtimeM);
//                }
//                else if (movieTypeM == 1) {
//                    return new LongTimeMovieEntity(idM, originalTitleM, titleM, "Korku", timeLenghtM);
//                }
//                else if (movieTypeM == 2) {
//                    return new SeriesMovieEntity(idM, originalTitleM, titleM, "Korku", seasonsM, episodesM);
//                }
//            }
//
//            conn.commit(); // we commit to transaction by-myself
//
//        }//end try
//        catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } finally {
//            //finally block used to close resources
//            try {
//                if (stmt != null)
//                    stmt.close();
//            } catch (SQLException se) {
//            }// do nothing
//            try {
//                if (conn != null)
//                    conn.close();
//            } catch (SQLException se) {
//                se.printStackTrace();
//            }   //end finally try
//        }   //end try
//        return null;
//    }
//}