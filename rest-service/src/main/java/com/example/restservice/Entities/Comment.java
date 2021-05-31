package com.example.restservice.Entities;

public class Comment {

    private String userID;
    private int commentId;
    private int movieId;

    private String comment;

    public Comment(String userID, int commentId, int movieId, String comment) {
        this.userID = userID;
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
        this.userID = userID;
        this.comment = comment;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
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
                "userID=" + userID +
                ", commentId=" + commentId +
                ", movieId=" + movieId +
                ", comment='" + comment + '\'' +
                '}';
    }
}
