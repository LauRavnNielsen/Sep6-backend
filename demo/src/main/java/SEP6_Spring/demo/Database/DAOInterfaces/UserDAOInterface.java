package SEP6_Spring.demo.Database.DAOInterfaces;

import SEP6_Spring.demo.Entities.User;

import java.sql.SQLException;

public interface UserDAOInterface {

    int Registry(User user) throws SQLException;

    User LogIn(String userName, String password) throws SQLException;
}
