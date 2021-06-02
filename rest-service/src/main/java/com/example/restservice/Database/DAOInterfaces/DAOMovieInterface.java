package com.example.restservice.Database.DAOInterfaces;

import com.example.restservice.Entities.Movie;
import com.example.restservice.Entities.MovieList;

import java.sql.SQLException;

public interface DAOMovieInterface {
    int addMovie(Movie movie) throws SQLException;
    Movie getMovie(String movieName) throws SQLException;
}
