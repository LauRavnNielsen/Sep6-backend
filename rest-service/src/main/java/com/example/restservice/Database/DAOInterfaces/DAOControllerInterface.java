package com.example.restservice.Database.DAOInterfaces;

import com.example.restservice.Entities.Controller;
import com.example.restservice.Entities.Movie;

import java.sql.SQLException;
import java.util.List;

public interface DAOControllerInterface {

    int AddMovieToMovieList(Controller controller, String movieName, String userName) throws SQLException;

    List<Movie> GetAllMovieForMovieList(String userName, String listName) throws SQLException;


    void DeleteMovieFromList(String movieName) throws SQLException;
}
