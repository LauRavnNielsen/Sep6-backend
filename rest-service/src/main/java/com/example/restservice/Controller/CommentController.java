package com.example.restservice.Controller;

import com.example.restservice.Database.DAOImplementation.CommentDAOImplementation;
import com.example.restservice.Entities.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
public class CommentController {

    @Autowired
    CommentDAOImplementation services;

    @PostMapping("/comment/AddComment")
    public void addComment(String comment, String movieName, String userName) throws SQLException {
        Comment addComment = new Comment();
        addComment.setComment(comment);

        services.AddCommentToMovie(addComment,movieName,userName);
    }

    @GetMapping("/comment/getComments")
    private List<Comment> getComments(String movieName) throws SQLException {
        return services.GetAllCommentsForMovie(movieName);

    }


}
