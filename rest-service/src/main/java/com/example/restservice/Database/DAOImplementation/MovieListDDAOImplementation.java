package com.example.restservice.Database.DAOImplementation;

import com.example.restservice.Database.DAOInterfaces.DAOMovieListInterface;
import com.example.restservice.Database.DatabaseConnection.LocalDBConnection;
import com.example.restservice.Entities.MovieList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MovieListDDAOImplementation implements DAOMovieListInterface {


    Connection connection = LocalDBConnection.getConnection();


    @Override
    public int AddMovieList(MovieList movieList, String username) throws SQLException {



        String query = "INSERT INTO movieList(pkUserName, " + "listName) VALUES ((SELECT userName FROM user WHERE userName = ?), ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        preparedStatement.setString(1,username);
        preparedStatement.setString(2,movieList.getListName());


        int n = preparedStatement.executeUpdate();

        return n;

    }

    @Override
    public void Delete(String listName, String username) throws SQLException {
        String query = "DELETE FROM user WHERE userName = ? AND listName = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(query);

        preparedStatement.setString(1, username);
        preparedStatement.setString(2, listName);
        preparedStatement.executeUpdate();

    }
}
