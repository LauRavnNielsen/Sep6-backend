package com.example.restservice.Entities;

public class Comment {

    private String userName;
    private int commentId;
    private int movieId;

    private String comment;

    public Comment(String userID, int commentId, int movieId, String comment) {
        this.userName = userID;
        this.commentId = commentId;
        this.movieId = movieId;
        this.comment = comment;
    }

    public Comment() {
    }

    public Comment(String comment) {
        this.comment = comment;
    }

    public Comment(String userID, String comment) {
        this.userName = userID;
        this.comment = comment;
    }

    public String getUserID() {
        return userName;
    }

    public void setUserID(String userID) {
        this.userName = userID;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "userID=" + userName +
                ", commentId=" + commentId +
                ", movieId=" + movieId +
                ", comment='" + comment + '\'' +
                '}';
    }
}
