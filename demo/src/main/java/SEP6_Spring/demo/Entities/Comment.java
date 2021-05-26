package SEP6_Spring.demo.Entities;

public class Comment {

    private int userID;
    private int commentId;
    private int movieId;

    private String comment;

    public Comment(int userID, int commentId, int movieId, String comment) {
        this.userID = userID;
        this.commentId = commentId;
        this.movieId = movieId;
        this.comment = comment;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
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
}
