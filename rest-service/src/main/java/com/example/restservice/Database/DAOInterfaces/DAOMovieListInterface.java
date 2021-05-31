package com.example.restservice.Database.DAOInterfaces;

import com.example.restservice.Entities.MovieList;

import java.sql.SQLException;
import java.util.List;

public interface DAOMovieListInterface {
    int addMovieList(MovieList movieList, String username) throws SQLException;

    List<MovieList> getMovieList(String userName) throws SQLException;

    void delete(String listName, String username) throws SQLException;
}
