package SEP6_Spring.demo.Database.DAOInterfaces;

import SEP6_Spring.demo.Entities.MovieList;

import java.sql.SQLException;

public interface MovieListDAOInterface {

    int CreateMovieList(MovieList movieList, int id) throws SQLException;
}
