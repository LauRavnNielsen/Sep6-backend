package com.example.restservice.Controller;

import com.example.restservice.Database.DAOImplementation.UserDAOImplementation;
import com.example.restservice.Entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@CrossOrigin
public class UserController {

    @Autowired
    private UserDAOImplementation services;

    @GetMapping("/Test")
    public String Test()
    {
        return "Hello World";
    }

    @PostMapping("/user/Register")
    public void Register(String userName, String password, String email) throws SQLException {


        User user = new User();
        user.setUserName(userName);
        user.setPassword(password);
        user.setEmail(email);

        services.Registry(user);
        System.out.println("Debug user object: " + user.toString());
    }

    @GetMapping("/user/Login")
    public Boolean LogIn(String userName, String password) throws SQLException
    {
        return services.LogIn(userName,password);
    }









}
