package com.example.restservice.Database.DAOImplementation;


import com.example.restservice.Database.DAOInterfaces.MovieDAOInterface;
import com.example.restservice.Database.DatabaseConnection.LocalDBConnection;
import com.example.restservice.Entities.Movie;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Service
public class MovieDAOImplementation implements MovieDAOInterface {

    Connection connection = LocalDBConnection.getConnection();

    @Override
    public int addMovie(Movie movie) throws SQLException {


        String query = "INSERT INTO movie(movieAPIId, " + "movieName, " + "director, " +  "year) VALUES (?, ?, ?, ?)";

        PreparedStatement preparedStatement = connection.prepareStatement(query);

        preparedStatement.setString(1,movie.getMovieApiId().toString());
        preparedStatement.setString(2,movie.getMovieName().toString());
        preparedStatement.setString(3,movie.getDirector().toString());
        preparedStatement.setInt(4,movie.getYear());

        System.out.println("Debug database: " + movie.toString() );

        int n = preparedStatement.executeUpdate();

        return n;
    }

    @Override
    public Movie getMovie(String movieName) throws SQLException {
        return null;
    }
}
