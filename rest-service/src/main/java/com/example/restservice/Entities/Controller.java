package com.example.restservice.Entities;

public class Controller {

    private int movieListId;
    private int movieId;

    private int row;

    public Controller( int movieListId, int movieId, int row) {

        this.movieListId = movieListId;
        this.movieId = movieId;
        this.row = row;
    }

    public Controller() {
    }



    public int getMovieListId() {
        return movieListId;
    }

    public void setMovieListId(int movieListId) {
        this.movieListId = movieListId;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    @Override
    public String toString() {
        return "Controller{" +
                ", movieListId=" + movieListId +
                ", movieId=" + movieId +
                ", row=" + row +
                '}';
    }
}
