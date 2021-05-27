package SEP6_Spring.demo.Database.DAOImplementation;

import SEP6_Spring.demo.Database.DAOInterfaces.MovieDAOInterface;
import SEP6_Spring.demo.Database.DatabaseConnection.LocalDBConnection;
import SEP6_Spring.demo.Entities.Movie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MovieDAOImplementation implements MovieDAOInterface {

    Connection connection = LocalDBConnection.getConnection();

    @Override
    public int addMovie(Movie movie) throws SQLException {

        String query = "INSERT INTO user(movieApiID, " + "movieName, " + "directorName, " + "genre, " + "imdbRating, " + "description, " + "year) VALUES (?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement preparedStatement = connection.prepareStatement(query);

        preparedStatement.setString(1,movie.getMovieApiId());
        preparedStatement.setString(2,movie.getMovieName());
        preparedStatement.setString(3,movie.getDirectorName());
        preparedStatement.setString(4,movie.getGenre());
        preparedStatement.setFloat(5,movie.getImdbRating());
        preparedStatement.setString(6,movie.getDescription());
        preparedStatement.setInt(7,movie.getYear());

        int n = preparedStatement.executeUpdate();

        return n;
    }

    @Override
    public Movie getMovie(int id) throws SQLException {
        return null;
    }
}
