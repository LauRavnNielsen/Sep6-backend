package SEP6_Spring.demo.Entities;

public class Rate {

    private int userId;
    private int rateId;
    private int movieId;

    private float rating;

    public Rate(int userId, int rateId, int movieId, int rating) {
        this.userId = userId;
        this.rateId = rateId;
        this.movieId = movieId;
        this.rating = rating;
    }

    public Rate() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Rate{" +
                "userId=" + userId +
                ", rateId=" + rateId +
                ", movieId=" + movieId +
                ", rating=" + rating +
                '}';
    }
}
