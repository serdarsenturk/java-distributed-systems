package com.serdarsenturk;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.io.IOException;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException, SQLException, IllegalAccessException, InstantiationException {
//        Movie movie17 = new SeriesMovie(88, "Nebilem", "A", Genre.Action, 18, 5);
//        mysqlDatabase.create(movie17);
//        var detailOfMovie17 = (mysqlDatabase.getById(88));
//
//        HomePage.movieDetails(88);

        //TODO Get new movie through DummyMovieService
//        var movie = new DummyMovieService();
//        MoviesEntity newMovie = (MoviesEntity) movie.getById(3);

        String query = "https://api.themoviedb.org/3/movie/550?api_key=1412bb0910c171bc419e90e2f68f47e6&language=en-US";

        try{
            StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
            Metadata meta=new MetadataSources(ssr).getMetadataBuilder().build();

            SessionFactory factory=meta.buildSessionFactory();
            Session session=factory.openSession();
            Transaction t = session.beginTransaction();
            var dummy = new DummyMovieService(query);

            if(query.contains("movie")){
                MoviesEntity newMovie = (MoviesEntity) dummy.getById(5);
                // Create method in Hibernate
                // TODO add new movie details different classes though one-to-one rel.

                MoviesEntity shm1 = new MoviesEntity();
                MovieEntity shm2 = new MovieEntity();

                shm2.setId(newMovie.getId());
                shm2.setOriginalTitle(newMovie.getOriginalTitle());
                shm2.setTitle(newMovie.getTitle());
                shm2.setGenre(newMovie.getGenre());
                shm2.setMovieType(0);
                session.persist(shm2);

                shm1.setId(newMovie.getId());
                shm1.setRuntime(newMovie.getRuntime());
                shm1.setRevenue(newMovie.getRevenue());
                session.persist(shm1);

                t.commit();

                System.out.println("Succesfully saved");
                factory.close();
                session.close();

            }
            else if (query.contains("tv")){
                TvShowsEntity newTvShow = (TvShowsEntity) dummy.getById(5);

                TvShowsEntity tkm1 = new TvShowsEntity();
                MovieEntity tkm2 = new MovieEntity();

                tkm2.setId(newTvShow.getId());
                tkm2.setOriginalTitle(newTvShow.getOriginalTitle());
                tkm2.setTitle(newTvShow.getTitle());
                tkm2.setGenre(newTvShow.getGenre());
                tkm2.setMovieType(newTvShow.getMovieType());

                session.persist(tkm2);

                tkm1.setEpisodes(newTvShow.getEpisodes());
                tkm1.setSeasons(newTvShow.getSeasons());
                tkm1.setEpisodesRuntime(newTvShow.getEpisodesRuntime());

                session.persist(tkm1);

                t.commit();

                System.out.println("Succesfully saved");
                factory.close();
                session.close();
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Bulanamadi");
        }

    }
}