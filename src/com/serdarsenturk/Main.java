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

        try{
            StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
            Metadata meta=new MetadataSources(ssr).getMetadataBuilder().build();

            SessionFactory factory=meta.buildSessionFactory();
            Session session=factory.openSession();
            Transaction t = session.beginTransaction();
            var dummy = new DummyMovieService();

            //Dummy code
            var kkk = dummy.getById(110);

            if(kkk instanceof MoviesEntity){
                MoviesEntity newMovie = (MoviesEntity) dummy.getById(110);

                MoviesEntity shm1 = new MoviesEntity();
                MovieEntity shm2 = new MovieEntity();

                shm2.setId(newMovie.getId());
                shm2.setOriginalTitle(newMovie.getOriginalTitle());
                shm2.setTitle(newMovie.getTitle());
                shm2.setGenre(newMovie.getGenre());
                shm2.setOriginalLanguage(newMovie.getOriginalLanguage());
                shm2.setVoteAverage(newMovie.getVoteAverage());
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
            if (kkk instanceof TvShowsEntity){
                TvShowsEntity newTvShow = (TvShowsEntity) dummy.getById(110);

                TvShowsEntity tkm1 = new TvShowsEntity();
                MovieEntity tkm2 = new MovieEntity();

                tkm2.setId(newTvShow.getId());
                tkm2.setOriginalTitle(newTvShow.getOriginalTitle());
                tkm2.setTitle(newTvShow.getTitle());
                tkm2.setGenre(newTvShow.getGenre());
                tkm2.setOriginalLanguage(newTvShow.getOriginalLanguage());
                tkm2.setVoteAverage(newTvShow.getVoteAverage());
                tkm2.setMovieType(1);

                session.save(tkm2);

                tkm1.setId(newTvShow.getId());
                tkm1.setEpisodes(newTvShow.getEpisodes());
                tkm1.setSeasons(newTvShow.getSeasons());
                tkm1.setEpisodesRuntime(newTvShow.getEpisodesRuntime());

                session.save(tkm1);

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