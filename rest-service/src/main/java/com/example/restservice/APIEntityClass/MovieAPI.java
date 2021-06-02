package com.example.restservice.APIEntityClass;


import com.example.restservice.Database.DAOImplementation.MovieDAOImplementation;
import com.example.restservice.Entities.Movie;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;


public class MovieAPI {

    private String apiKey = "17bbff48";
    private String baseUrl = "http://www.omdbapi.com/?";

    MovieDAOImplementation services;


    public Movie getMovieInfoFromAPI(String movieName) throws IOException {

        URL url = new URL(baseUrl + "t=" + movieName + "&apikey=" + apiKey);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        con.setRequestMethod("GET");

        con.connect();

        Scanner sc = new Scanner(url.openStream());
        String inline = "";

        while(sc.hasNext())
        {
            inline+=sc.nextLine();
        }
        System.out.println("\nJSON data in string format");
        System.out.println(inline);
        sc.close();

        Gson gson = new Gson();
        MovieEntity movieFromApi = gson.fromJson(inline, MovieEntity.class);

        Movie newMovie = new Movie(movieFromApi);


        return newMovie;
  }





}
