package com.example.restservice.Database.DAOImplementation;

import com.example.restservice.APIEntityClass.MovieAPI;
import com.example.restservice.Database.DAOInterfaces.DAOControllerInterface;
import com.example.restservice.Database.DatabaseConnection.LocalDBConnection;
import com.example.restservice.Entities.Controller;
import com.example.restservice.Entities.Movie;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class ControllerDAOImplementation implements DAOControllerInterface {


    Connection connection = LocalDBConnection.getConnection();

    MovieAPI movieAPI = new MovieAPI();

    MovieDAOImplementation movieDAOImplementation = new MovieDAOImplementation();

    @Override
    public int AddMovieToMovieList(Controller controller, String movieName, String userName) throws SQLException {

        String query = "SELECT * FROM movie WHERE movieName = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(query);

        preparedStatement.setString(1,movieName);



        ResultSet resultSet = preparedStatement.executeQuery();

        Boolean movieExists = false;


        while(resultSet.next())
        {
            movieExists = true;
        }

        if(movieExists == true) {




            String createControllerQuery = "INSERT INTO controller(movieIdNumber, " +
                    "movieListId, " + "row1) " +
                    "VALUES ((SELECT movieId FROM movie WHERE movieName = ?), (SELECT movieListId FROM movieList WHERE pkUserName = ?), ?)";

            PreparedStatement preparedStatement2 = connection.prepareStatement(createControllerQuery);

            preparedStatement2.setString(1, movieName);
            preparedStatement2.setString(2, userName);
            preparedStatement2.setInt(3, controller.getRow());

            int n = preparedStatement2.executeUpdate();
            return n;
        } else{


            Movie movie = new Movie();
        try {
            movie = movieAPI.getMovieInfoFromAPI(movieName);

            System.out.println("Debug movie api: " + movie.toString());

            movieDAOImplementation.addMovie(movie);

        } catch (IOException e) {
            e.printStackTrace();
        }

            String createControllerQuery = "INSERT INTO controller(movieIdNumber, " +
                    "movieListId, " + "row1) " +
                    "VALUES ((SELECT movieId FROM movie WHERE movieName = ?), (SELECT movieListId FROM movieList WHERE pkUserName = ?), ?)";

            PreparedStatement preparedStatement2 = connection.prepareStatement(createControllerQuery);
            preparedStatement2.setString(1, movieName);
            preparedStatement2.setString(2, userName);
            preparedStatement2.setInt(3, controller.getRow());

            int n = preparedStatement2.executeUpdate();
            return n;
        }


    }

    @Override
    public List<Movie> GetAllMovieForMovieList(String userName, String listName) throws SQLException {


        String getAllMovieQuery = "SELECT movie.movieName, movie.director, movie.year , controller.row1, movieList.movieListId " +
                "FROM controller " +
                "JOIN movie ON movie.movieId = controller.movieIdNumber " +
                "JOIN movieList ON movieList.movieListId = controller.movieListId " +
                "WHERE movieList.pkUserName = ? and movieList.listName = ? " +
                "ORDER BY controller.row1";

        PreparedStatement preparedStatement = connection.prepareStatement(getAllMovieQuery);

        preparedStatement.setString(1,userName);
        preparedStatement.setString(2,listName);

        ResultSet resultSet = preparedStatement.executeQuery();

        List<Movie> movieList = new ArrayList<>();
        Movie movie = new Movie();

        while(resultSet.next())
        {
            movie.setMovieName(resultSet.getString("movieName"));
            movie.setDirector(resultSet.getString("director"));
            movie.setYear(resultSet.getInt("year"));

            movieList.add(movie);
        }



        return movieList;
    }

    @Override
    public void DeleteMovieFromList(String movieName) throws SQLException {

    }
}
