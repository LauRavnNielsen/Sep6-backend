package com.example.restservice.Controller;

import com.example.restservice.Database.DAOImplementation.ControllerDAOImplementation;
import com.example.restservice.Entities.Controller;
import com.example.restservice.Entities.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
public class ControllerController {

    @Autowired
    ControllerDAOImplementation services;


    @PostMapping("/toMovieList/AddMovie")
    public void addMovieToMovieList(int row,String movieName, String userName, String listName) throws SQLException {
        Controller controller = new Controller();
        controller.setRow(row);
        services.AddMovieToMovieList(controller,movieName,userName,listName);
    }

    @GetMapping("toMovieList/getListsOfMovies")
    public List<Movie> getAllMoviesForMovieList(String userName, String listName) throws SQLException {
        return services.GetAllMovieForMovieList(userName,listName);
    }

    /*
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
     */

}
