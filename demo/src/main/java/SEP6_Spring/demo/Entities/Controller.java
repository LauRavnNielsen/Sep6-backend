package SEP6_Spring.demo.Entities;

public class Controller {
    private int userId;
    private int movieListId;
    private int movieId;

    private int row;

    public Controller(int userId, int movieListId, int movieId, int row) {
        this.userId = userId;
        this.movieListId = movieListId;
        this.movieId = movieId;
        this.row = row;
    }

    public Controller() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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
                "userId=" + userId +
                ", movieListId=" + movieListId +
                ", movieId=" + movieId +
                ", row=" + row +
                '}';
    }
}
