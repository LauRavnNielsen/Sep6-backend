package com.example.restservice.Database.DAOImplementation;

import com.example.restservice.APIEntityClass.MovieAPI;
import com.example.restservice.Database.DAOInterfaces.DAOCommentInterface;
import com.example.restservice.Database.DatabaseConnection.LocalDBConnection;
import com.example.restservice.Entities.Comment;
import com.example.restservice.Entities.Movie;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CommentDAOImplementation implements DAOCommentInterface {

    Connection connection = LocalDBConnection.getConnection();

    MovieAPI movieAPI = new MovieAPI();

    MovieDAOImplementation movieDAOImplementation = new MovieDAOImplementation();

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

            String commentQuery = "INSERT INTO comment1(IDmovie, " + "UserNamePK, " + "comment) VALUES ((SELECT movieId FROM movie WHERE movieName = ?)" +
                    ", (SELECT userName FROM user WHERE userName = ?), ?)";

            PreparedStatement preparedStatement2 = connection.prepareStatement(commentQuery);

            preparedStatement2.setString(1,movieNameGiven); //should be string
            preparedStatement2.setString(2,userName);
            preparedStatement2.setString(3,comment.getComment());

            int n = preparedStatement2.executeUpdate();

            return n;

        }else
        {
            //API  CALL
            Movie movie = new Movie();
            try {
               movie = movieAPI.getMovieInfoFromAPI(movieNameGiven);

                System.out.println("Debug movie api: " + movie.toString());

               movieDAOImplementation.addMovie(movie);

            } catch (IOException e) {
                e.printStackTrace();
            }

            String commentQuery = "INSERT INTO comment1(IDmovie, " + "UserNamePK, " + "comment) VALUES ((SELECT movieId FROM movie WHERE movieName = ?)" +
                    ", (SELECT userName FROM user WHERE userName = ?), ?)";

            PreparedStatement preparedStatement2 = connection.prepareStatement(commentQuery);

            preparedStatement2.setString(1,movieNameGiven); //should be string
            preparedStatement2.setString(2,userName);
            preparedStatement2.setString(3,comment.getComment());



            int n = preparedStatement2.executeUpdate();

            return n;
        }



    }

    @Override
    public List<Comment> GetAllCommentsForMovie(String movieName) throws SQLException {

        String commentsOnMovieQuery = "SELECT comment, userNamePK " +
                "FROM comment1 " +
                "WHERE comment1.IDmovie = ( SELECT movieId FROM movie WHERE movie.movieName = ?)  " +
                "ORDER BY comment1.commentId";

        PreparedStatement  preparedStatement = connection.prepareStatement(commentsOnMovieQuery);

        preparedStatement.setString(1,movieName);

        ResultSet resultSet = preparedStatement.executeQuery();

        List<Comment> commentList = new ArrayList<>();


        while(resultSet.next())
        {


            commentList.add(new Comment(resultSet.getString("userNamePK"), resultSet.getString("comment")));


        }
        System.out.println("DEBUG comment: " + commentList);

        return commentList;
    }

    @Override
    public void DeleteComment(String comment) throws SQLException {

        String query = "";

        PreparedStatement preparedStatement = connection.prepareStatement(query);

    }
}
