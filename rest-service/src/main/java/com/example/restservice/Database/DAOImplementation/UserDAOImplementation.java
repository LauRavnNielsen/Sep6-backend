package com.example.restservice.Database.DAOImplementation;



import com.example.restservice.Database.DAOInterfaces.DAOUserInterface;
import com.example.restservice.Database.DatabaseConnection.LocalDBConnection;
import com.example.restservice.Entities.User;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class UserDAOImplementation implements DAOUserInterface {


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
    public Boolean LogIn(String userName, String password) throws SQLException {
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

     }

    return check;


    }

    //based on username
    @Override
    public void Delete(String username) throws SQLException {
        String query = "DELETE FROM user WHERE userName = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(query);

        preparedStatement.setString(1, username);
        preparedStatement.executeUpdate();
    }
}
