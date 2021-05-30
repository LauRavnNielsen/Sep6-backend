package com.example.restservice.Database.DAOInterfaces;

import com.example.restservice.Entities.Rate;

import java.sql.SQLException;

public interface DAORateInterface {

    int AddRatingToMovie(Rate rate, String movieName, String username) throws SQLException;
}
