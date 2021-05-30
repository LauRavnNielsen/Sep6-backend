package com.example.restservice.Database.DAOInterfaces;

import com.example.restservice.Entities.MovieList;

import java.sql.SQLException;

public interface DAOMovieListInterface {
    int AddMovieList(MovieList movieList, String username) throws SQLException;

    void Delete(String listName, String username) throws SQLException;
}
