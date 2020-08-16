package com.serdarsenturk;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.serdarsenturk.Movie;
import com.sun.xml.bind.api.impl.NameConverter;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.security.KeyException;
import java.sql.*;
import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException, SQLException {
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
        MovieEntity m1 = new MovieEntity();
        m1.setId(118);
        m1.setOriginalTitle("Kalk");
        m1.setTitle("Gel");
        m1.setGenre("Korku");
        m1.setMovieType(2);

        session.save(m1);

        t.commit();
        System.out.println("Succesfully saved");
        factory.close();
        session.close();
    }
}

