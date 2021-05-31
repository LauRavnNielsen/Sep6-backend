package com.example.restservice.Database.DAOInterfaces;

import com.example.restservice.Entities.Rate;

import java.sql.SQLException;

public interface DAORateInterface {

    int addRatingToMovie(Rate rate, String movieName, String username) throws SQLException;

    float getRatingOnMovie(String userName, String movieName) throws  SQLException;
}
