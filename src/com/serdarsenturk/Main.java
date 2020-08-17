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


        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

        SessionFactory factory = meta.getSessionFactoryBuilder().build();
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();

        // Create method in Hibernate
        // TODO add to at the same time series_movie class
        // TODO Find another way merge to one-to-one relationships entities



        ShortMovieEntity shm1 = new ShortMovieEntity();
        MovieEntity shm2 = new MovieEntity();

        shm2.setShortMovieEntity(shm1);
        shm2.setId(12);
        shm2.setOriginalTitle("a");
        shm2.setTitle("K");
        shm2.setGenre("Korku");
        shm2.setMovieType(0);

        shm1.setMovieEntity(shm2);
        shm1.setId(12);
        shm1.setRuntime(122);

        //Basically we merge a pair of entities
        session.merge(shm2);
        session.merge(shm1);

        t.commit();
        System.out.println("Succesfully saved");
        factory.close();
        session.close();
    }
}

