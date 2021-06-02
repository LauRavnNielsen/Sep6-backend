package com.example.restservice.Database.DAOImplementation;

import com.example.restservice.Database.DAOInterfaces.DAOMovieListInterface;
import com.example.restservice.Database.DatabaseConnection.LocalDBConnection;
import com.example.restservice.Entities.MovieList;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class MovieListDAOImplementation implements DAOMovieListInterface {

    Connection connection = LocalDBConnection.getConnection();

    @Override
    public int addMovieList(MovieList movieList, String username) throws SQLException {

        String query = "INSERT INTO movieList(pkUserName, " +
                "listName) VALUES ((SELECT userName FROM user WHERE userName = ?), ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        preparedStatement.setString(1,username);
        preparedStatement.setString(2,movieList.getListName());

        int n = preparedStatement.executeUpdate();

        return n;
    }

    @Override
    public List<MovieList> getMovieList(String userName) throws SQLException {

        String getMovieListsQuery = "SELECT listName " +
                "FROM movies.movielist " +
                "WHERE pkUserName = ? " +
                "ORDER BY movieListId;";

        PreparedStatement preparedStatement = connection.prepareStatement(getMovieListsQuery);

        preparedStatement.setString(1,userName);

        ResultSet resultSet = preparedStatement.executeQuery();

        List<MovieList> movieLists = new ArrayList<>();

        while (resultSet.next())
        {
            movieLists.add(new MovieList(resultSet.getString("listName")));
        }

        return movieLists;
    }

    @Override
    public void delete(String listName, String username) throws SQLException {
        String query = "DELETE FROM user WHERE userName = ? AND listName = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(query);

        preparedStatement.setString(1, username);
        preparedStatement.setString(2, listName);
        preparedStatement.executeUpdate();

    }
}
