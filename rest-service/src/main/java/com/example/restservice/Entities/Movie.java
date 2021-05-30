package com.example.restservice.Entities;

import com.example.restservice.APIEntityClass.MovieEntity;

public class Movie {

    private int movieId;

    private String movieAPIId;

    private String movieName;
    private String director;
    private int year;


    public Movie() {
    }

    public Movie(int movieId, String movieAPIId, String movieName, String director, int year) {
        this.movieId = movieId;
        this.movieAPIId = movieAPIId;
        this.movieName = movieName;
        this.director = director;
        this.year = year;
    }


    public Movie(MovieEntity movieEntity) {
        this.movieAPIId = movieEntity.getImdbId();
        this.movieName = movieEntity.getTitle();
        this.director = movieEntity.getDirector();
        this.year = movieEntity.getYear();
    }



    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getMovieApiId() {
        return movieAPIId;
    }

    public void setMovieApiId(String movieApiId) {
        this.movieAPIId = movieApiId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieId=" + movieId +
                ", movieApiId='" + movieAPIId + '\'' +
                ", movieName='" + movieName + '\'' +
                ", director='" + director + '\'' +
                ", year=" + year +
                '}';
    }
}
