package SEP6_Spring.demo.Entities;

public class Movie {

    private int movieId;

    private String movieApiId;

    private String movieName;
    private String directorName;
    private String genre;
    private String description;
    private int year;
    private float imdbRating;

    public Movie(int movieId, String movieApiId, String movieName, String directorName, String genre, String description, int year, int imdbRating) {
        this.movieId = movieId;
        this.movieApiId = movieApiId;
        this.movieName = movieName;
        this.directorName = directorName;
        this.genre = genre;
        this.description = description;
        this.year = year;
        this.imdbRating = imdbRating;
    }

    public Movie() {
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getMovieApiId() {
        return movieApiId;
    }

    public void setMovieApiId(String movieApiId) {
        this.movieApiId = movieApiId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public float getImdbRating() {
        return imdbRating;
    }


    public void setImdbRating(float imdbRating) {
        this.imdbRating = imdbRating;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieId=" + movieId +
                ", movieApiId='" + movieApiId + '\'' +
                ", movieName='" + movieName + '\'' +
                ", directorName='" + directorName + '\'' +
                ", genre='" + genre + '\'' +
                ", description='" + description + '\'' +
                ", year=" + year +
                ", imdbRating=" + imdbRating +
                '}';
    }
}
