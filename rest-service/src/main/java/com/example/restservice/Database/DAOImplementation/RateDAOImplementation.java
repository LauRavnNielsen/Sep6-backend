package com.example.restservice.Database.DAOImplementation;

import com.example.restservice.APIEntityClass.MovieAPI;
import com.example.restservice.Database.DAOInterfaces.DAORateInterface;
import com.example.restservice.Database.DatabaseConnection.LocalDBConnection;
import com.example.restservice.Entities.Movie;
import com.example.restservice.Entities.Rate;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


@Service
public class RateDAOImplementation implements DAORateInterface {

    Connection connection = LocalDBConnection.getConnection();

    MovieAPI movieAPI = new MovieAPI();

    MovieDAOImplementation movieDAOImplementation = new MovieDAOImplementation();

    @Override
    public int addRatingToMovie(Rate rate, String movieName, String username) throws SQLException {

        String query = "SELECT * FROM movie WHERE movieName = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(query);

        preparedStatement.setString(1,movieName);



        ResultSet resultSet = preparedStatement.executeQuery();

        Boolean movieExists = false;


        while(resultSet.next())
        {
            movieExists = true;
        }

        if(movieExists == true)
        {
            String rateQuery1 = "INSERT INTO rate(movieId, " + "userName, " + "rating) " +
                    "VALUES ((SELECT movieId FROM movie WHERE movieName = ?), (SELECT userName FROM user WHERE userName = ?), ?)";

            PreparedStatement preparedStatement2 = connection.prepareStatement(rateQuery1);

            preparedStatement2.setString(1,movieName);
            preparedStatement2.setString(2,username);
            preparedStatement2.setFloat(3,rate.getRating());

            System.out.println("DEBUG userName: " + username);

            int n = preparedStatement2.executeUpdate();

            return n;
        }else
        {
            Movie movie = new Movie();
            try {
                movie = movieAPI.getMovieInfoFromAPI(movieName);

                System.out.println("Debug movie api: " + movie.toString());

                movieDAOImplementation.addMovie(movie);

            } catch (IOException e) {
                e.printStackTrace();
            }

            String rateQuery = "INSERT INTO rate(movieId, " + "userName, " + "rating) " +
                    "VALUES ((SELECT movieId FROM movie WHERE movieName = ?), (SELECT userName FROM user WHERE userName = ?), ?)";

            PreparedStatement preparedStatement2 = connection.prepareStatement(rateQuery);

            preparedStatement2.setString(1,movieName);
            preparedStatement2.setString(2,username);
            preparedStatement2.setFloat(3,rate.getRating());

            int n = preparedStatement2.executeUpdate();

            return n;
        }





    }

    @Override
    public float getRatingOnMovie(String userName, String movieName) throws SQLException {

        String rateQuery = "SELECT rating " +
                "FROM rate " +
                "WHERE rate.userName = ? AND movieId = (SELECT movieId FROM movie WHere movieName = ?)";

        PreparedStatement preparedStatement = connection.prepareStatement(rateQuery);

        preparedStatement.setString(1,userName);
        preparedStatement.setString(2,movieName);

        ResultSet resultSet = preparedStatement.executeQuery();
        Float number = 0f;

        while (resultSet.next())
        {
            number = resultSet.getFloat("rating");
        }

        return number;
    }
}
