package com.example.restservice.Database.DAOInterfaces;

import com.example.restservice.Entities.Controller;

import java.sql.SQLException;

public interface DAOControllerInterface {

    int AddMovieToMovieList(Controller controller) throws SQLException;

    void DeleteMovieFromList(String movieName) throws SQLException;
}
