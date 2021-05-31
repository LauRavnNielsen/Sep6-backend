package com.example.restservice.Database.DAOInterfaces;

import com.example.restservice.Entities.Comment;

import java.sql.SQLException;
import java.util.List;

public interface DAOCommentInterface {

    int AddCommentToMovie(Comment comment, String movieName, String username) throws SQLException;

    List<Comment> GetAllCommentsForMovie(String movieName) throws SQLException;

    void DeleteComment(String comment) throws SQLException;
}
