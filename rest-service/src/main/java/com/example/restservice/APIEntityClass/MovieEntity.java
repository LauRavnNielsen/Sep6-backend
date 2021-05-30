package com.example.restservice.APIEntityClass;

public class MovieEntity {


    private String Title;
    private int Year;
    private String Director;

    private String imdbID;

    public MovieEntity(String title, int year, String director, String imdbId) {
        Title = title;
        Year = year;
        Director = director;
        this.imdbID = imdbId;
    }

    public MovieEntity() {
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public int getYear() {
        return Year;
    }

    public void setYear(int year) {
        Year = year;
    }

    public String getDirector() {
        return Director;
    }

    public void setDirector(String director) {
        Director = director;
    }

    public String getImdbId() {
        return imdbID;
    }

    public void setImdbId(String imdbId) {
        this.imdbID = imdbId;
    }


    @Override
    public String toString() {
        return "MovieEntity{" +
                "Title='" + Title + '\'' +
                ", Year=" + Year +
                ", Director='" + Director + '\'' +
                ", imdbID='" + imdbID + '\'' +
                '}';
    }
}
