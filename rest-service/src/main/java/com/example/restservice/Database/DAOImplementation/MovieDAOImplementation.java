package com.example.restservice.Database.DAOImplementation;


import com.example.restservice.Database.DAOInterfaces.MovieDAOInterface;
import com.example.restservice.Database.DatabaseConnection.LocalDBConnection;
import com.example.restservice.Entities.Movie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MovieDAOImplementation implements MovieDAOInterface {

    Connection connection = LocalDBConnection.getConnection();

    @Override
    public int addMovie(Movie movie) throws SQLException {

        String query = "INSERT INTO user(movieApiID, " + "movieName, " + "director, " +  "year) VALUES (?, ?, ?, ?)";

        PreparedStatement preparedStatement = connection.prepareStatement(query);

        preparedStatement.setString(1,movie.getMovieApiId());
        preparedStatement.setString(2,movie.getMovieName());
        preparedStatement.setString(3,movie.getDirector());
        preparedStatement.setInt(4,movie.getYear());

        int n = preparedStatement.executeUpdate();

        return n;
    }

    @Override
    public Movie getMovie(String movieName) throws SQLException {
        return null;
    }
}
