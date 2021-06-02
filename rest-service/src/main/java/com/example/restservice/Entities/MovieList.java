package com.example.restservice.Entities;

public class MovieList {
    private String userName;
    private int movieListId;

    private String listName;

    public MovieList(String userName, int movieListId, String listName) {
        this.userName = userName;
        this.movieListId = movieListId;
        this.listName = listName;
    }

    public MovieList() {
    }

    public MovieList(String listName) {
        this.listName = listName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getMovieListId() {
        return movieListId;
    }

    public void setMovieListId(int movieListId) {
        this.movieListId = movieListId;
    }

    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }

    @Override
    public String toString() {
        return "MovieList{" +
                "userName=" + userName +
                ", movieListId=" + movieListId +
                ", listName='" + listName + '\'' +
                '}';
    }
}
