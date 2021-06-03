package com.example.restservice.Controller;

import com.example.restservice.Database.DAOImplementation.RateDAOImplementation;
import com.example.restservice.Entities.Rate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
@CrossOrigin
public class RateController {

    @Autowired
    private RateDAOImplementation services;

    @GetMapping("/rate/GetRating")
    public Float getRating(String userName, String movieName) throws SQLException {
        return services.getRatingOnMovie(userName,movieName);
    }


    @PostMapping("/rate/AddRating")
    public void addRating(float rating, String movieName, String userName) throws SQLException {
        Rate rate = new Rate();
        rate.setRating(rating);
        services.addRatingToMovie(rate,movieName,userName);
    }

}
