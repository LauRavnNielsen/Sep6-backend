package SEP6_Spring.demo.Database.DAOInterfaces;

import SEP6_Spring.demo.Entities.Movie;

import java.sql.SQLException;

public interface MovieDAOInterface {

    int addMovie(Movie movie) throws SQLException;
    Movie getMovie(int id) throws SQLException;
}
