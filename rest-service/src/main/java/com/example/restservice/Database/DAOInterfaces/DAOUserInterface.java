package com.example.restservice.Database.DAOInterfaces;

import com.example.restservice.Entities.User;

import java.sql.SQLException;

public interface DAOUserInterface {

    int Registry(User user) throws SQLException;

    Boolean LogIn(String userName, String password) throws SQLException;

    void Delete(String username) throws SQLException;
}
