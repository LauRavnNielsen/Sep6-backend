package com.example.restservice;

import com.example.restservice.APIEntityClass.MovieAPI;
import com.example.restservice.Database.DAOImplementation.*;
import com.example.restservice.Entities.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@SpringBootApplication
public class RestServiceApplication {

	public static void main(String[] args) throws SQLException, IOException {
		SpringApplication.run(RestServiceApplication.class, args);


	}



}
