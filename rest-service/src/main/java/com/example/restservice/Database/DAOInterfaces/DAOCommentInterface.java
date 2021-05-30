package com.example.restservice.Database.DAOInterfaces;

import com.example.restservice.Entities.Comment;

import java.sql.SQLException;

public interface DAOCommentInterface {

    int AddCommentToMovie(Comment comment, String movieName, String username) throws SQLException;

    void DeleteComment(String comment) throws SQLException;
}
