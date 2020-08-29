package com.serdarsenturk;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Scanner;

public class MainPage {

    public static void index() throws MalformedURLException, URISyntaxException {
        final String api_key = "1412bb0910c171bc419e90e2f68f47e6" ;

        System.out.println("Welcome to the MovieDb");
        System.out.println("1.Top-10 Movies");
        System.out.println("2.Top-10 Series");

        Scanner console = new Scanner(System.in);

        int selectNumber = console.nextInt();
        URLBuilder topRatedUrl = new URLBuilder("api.themoviedb.org");

        if (selectNumber == 1){
            topRatedUrl.setConnectionType("https");
            topRatedUrl.addSubfolder("3");
            topRatedUrl.addSubfolder("movie");
            topRatedUrl.addSubfolder("top_rated");
            topRatedUrl.addParameter("api_key", api_key);
            topRatedUrl.addParameter("language", "en-US");
            topRatedUrl.addParameter("page", "1");

            String url = topRatedUrl.getURL();
            System.out.println(url);
        }

        if(selectNumber == 2){
            topRatedUrl.setConnectionType("https");
            topRatedUrl.addSubfolder("3");
            topRatedUrl.addSubfolder("tv");
            topRatedUrl.addSubfolder("top_rated");
            topRatedUrl.addParameter("api_key", api_key);
            topRatedUrl.addParameter("language", "en=US");
            topRatedUrl.addParameter("page", "page");

            String url = topRatedUrl.getURL();
            System.out.println(url);
        }
    }

}
