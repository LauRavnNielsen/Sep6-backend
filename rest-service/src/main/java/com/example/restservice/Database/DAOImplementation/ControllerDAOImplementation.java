package com.example.restservice.Database.DAOImplementation;

import com.example.restservice.Database.DAOInterfaces.DAOControllerInterface;
import com.example.restservice.Database.DatabaseConnection.LocalDBConnection;
import com.example.restservice.Entities.Controller;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;

public class ControllerDAOImplementation implements DAOControllerInterface {


    Connection connection = LocalDBConnection.getConnection();

    @Override
    public int AddMovieToMovieList(Controller controller) throws SQLException {

        String query = "";

        PreparedStatement preparedStatement = connection.prepareStatement(query);

        return 0;
    }

    @Override
    public void DeleteMovieFromList(String movieName) throws SQLException {

    }
}
