package com.example.restservice.Controller;

import com.example.restservice.Database.DAOImplementation.MovieListDAOImplementation;
import com.example.restservice.Entities.MovieList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
@CrossOrigin
public class MovieListController {

    @Autowired
    MovieListDAOImplementation services;

    @PostMapping("/movieList/AddMovieList")
    public void addMovieList(String listName, String userName) throws SQLException {
        MovieList movieList = new MovieList();
        movieList.setListName(listName);
        services.addMovieList(movieList,userName);
    }

    @GetMapping("/movieList/getMovieListForUser")
    public List<MovieList> getMovieListsForUser(String userName) throws SQLException {
        return services.getMovieList(userName);
    }




}
