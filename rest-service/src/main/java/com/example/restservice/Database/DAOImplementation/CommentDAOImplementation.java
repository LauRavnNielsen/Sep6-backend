package com.example.restservice.Database.DAOImplementation;

import com.example.restservice.APIEntityClass.MovieAPI;
import com.example.restservice.Database.DAOInterfaces.DAOCommentInterface;
import com.example.restservice.Database.DatabaseConnection.LocalDBConnection;
import com.example.restservice.Entities.Comment;
import com.example.restservice.Entities.Movie;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CommentDAOImplementation implements DAOCommentInterface {

    Connection connection = LocalDBConnection.getConnection();

    MovieAPI movieAPI = new MovieAPI();

    @Override
    public int AddCommentToMovie(Comment comment, String movieNameGiven, String userName) throws SQLException {

        String query = "SELECT * FROM movie WHERE movieName = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(query);

        preparedStatement.setString(1,movieNameGiven);



        ResultSet resultSet = preparedStatement.executeQuery();

        Boolean movieExists = false;


        while(resultSet.next())
        {
            movieExists = true;
        }

        if(movieExists == true)
        {

            String query2 = "INSERT INTO comment1(IDmovie, " + "UserNamePK, " + "comment) VALUES ((SELECT movieId FROM movie WHERE movieName = ?)" +
                    ", (SELECT userName FROM user WHERE userName = ?), ?)";

            PreparedStatement preparedStatement2 = connection.prepareStatement(query2);

            preparedStatement2.setString(1,movieNameGiven); //should be string
            preparedStatement2.setString(2,userName);
            preparedStatement2.setString(3,comment.getComment());

            int n = preparedStatement2.executeUpdate();

            return n;

        }else
        {
            //API shit
            Movie movie = new Movie();
            try {
               movie = movieAPI.getMovieInfoFromAPI(movieNameGiven);

               String isertQuery = "";

            } catch (IOException e) {
                e.printStackTrace();
            }



            String query3 = "";
            return 0;
        }



    }

    @Override
    public void DeleteComment(String comment) throws SQLException {

        String query = "";

        PreparedStatement preparedStatement = connection.prepareStatement(query);

    }
}
