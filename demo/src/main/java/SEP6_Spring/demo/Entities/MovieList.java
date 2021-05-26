package SEP6_Spring.demo.Entities;

public class MovieList {
    private int userId;
    private int movieListId;

    private String listName;

    public MovieList(int userId, int movieListId, String listName) {
        this.userId = userId;
        this.movieListId = movieListId;
        this.listName = listName;
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

    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }
}
