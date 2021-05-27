package SEP6_Spring.demo.Database.DAOImplementation;

import SEP6_Spring.demo.Database.DAOInterfaces.UserDAOInterface;
import SEP6_Spring.demo.Database.DatabaseConnection.LocalDBConnection;
import SEP6_Spring.demo.Entities.User;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAOImplementation implements UserDAOInterface {


    static Connection connection = LocalDBConnection.getConnection();

    @Override
    public int Registry(User user) throws SQLException {
        String query = "INSERT INTO user(userName, " + "password, " + "email) VALUES (?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        preparedStatement.setString(1,user.getUserName());
        preparedStatement.setString(2,user.getPassword());
        preparedStatement.setString(3,user.getEmail());

        int n = preparedStatement.executeUpdate();

        return n;
    }

    @Override
    public User LogIn(String userName, String password) throws SQLException {
        String query = "SELECT * FROM user WHERE userName = ? and password = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        preparedStatement.setString(1,userName);
        preparedStatement.setString(2,password);

        User user = new User();

        ResultSet resultSet = preparedStatement.executeQuery();
        boolean check = false;


     while(resultSet.next())
     {
        check = true;
        user.setUserId(resultSet.getInt("userId"));
         user.setUserName(resultSet.getString("userName"));
         user.setPassword(resultSet.getString("password"));
         user.setEmail(resultSet.getString("email"));
     }

     if(check == true)
     {
         return user;
     }else
         return null;







    }

    @Override
    public void Delete(int id) throws SQLException {
        String query = "DELETE FROM user WHERE userId = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(query);

        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
    }
}
