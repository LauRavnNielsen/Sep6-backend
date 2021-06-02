package com.example.restservice.Entities;

public class Rate {

    private String userName;
    private int rateId;
    private int movieId;

    private float rating;

    public Rate() {
    }

    public Rate(String userName, int rateId, int movieId, float rating) {
        this.userName = userName;
        this.rateId = rateId;
        this.movieId = movieId;
        this.rating = rating;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getRateId() {
        return rateId;
    }

    public void setRateId(int rateId) {
        this.rateId = rateId;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Rate{" +
                "userName='" + userName + '\'' +
                ", rateId=" + rateId +
                ", movieId=" + movieId +
                ", rating=" + rating +
                '}';
    }
}
