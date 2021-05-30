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

	/*	MovieAPI movieAPI = new MovieAPI();
		movieAPI.getMovieInfoFromAPI("Inception");

	 */








		Controller controller = new Controller();
		controller.setRow(4);



		ControllerDAOImplementation controllerDAOImplementation = new ControllerDAOImplementation();
		//controllerDAOImplementation.AddMovieToMovieList(controller,"It","admin");
		List<Movie> movieList = controllerDAOImplementation.GetAllMovieForMovieList("admin","hate");

		System.out.println("Debug movieList: " + movieList);




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
