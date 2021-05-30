package com.example.restservice;

import com.example.restservice.APIEntityClass.MovieAPI;
import com.example.restservice.Database.DAOImplementation.CommentDAOImplementation;
import com.example.restservice.Database.DAOImplementation.UserDAOImplementation;
import com.example.restservice.Entities.Comment;
import com.example.restservice.Entities.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.sql.SQLException;

@SpringBootApplication
public class RestServiceApplication {

	public static void main(String[] args) throws SQLException, IOException {
		SpringApplication.run(RestServiceApplication.class, args);

		MovieAPI movieAPI = new MovieAPI();
		movieAPI.getMovieInfoFromAPI("Inception");
		/*User user = new User();
		user.setUserName("admin");
		user.setPassword("123456");
		user.setEmail("test@gmail.com");

		UserDAOImplementation userDao = new UserDAOImplementation();

		Comment comment = new Comment();
		comment.setComment("Thresh.");

		CommentDAOImplementation commentDAo = new CommentDAOImplementation();


		//Add Comment to movie

		commentDAo.AddCommentToMovie(comment,"lol","admin");

		//Register user to the database
		//	userDao.Registry(user);

		//Login Test with correct given info and without
		boolean e = userDao.LogIn("admin","123456");
		boolean f = userDao.LogIn("admin","12345");

		if(e == true) {
			System.out.println("Access granted");
		} else
			System.out.println("Incorrect username or password");

		if(f == true) {
			System.out.println("Access granted");
		} else
			System.out.println("Incorrect username or password");

		 */
	}



}
