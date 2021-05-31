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












		ControllerDAOImplementation controllerDAOImplementation = new ControllerDAOImplementation();
		//controllerDAOImplementation.AddMovieToMovieList(controller,"It","admin");
		List<Movie> movieList = controllerDAOImplementation.GetAllMovieForMovieList("admin","hate");

		//System.out.println("Debug movieList: " + movieList);

		CommentDAOImplementation commentDAOImplementation = new CommentDAOImplementation();

		List<Comment> commentList = commentDAOImplementation.GetAllCommentsForMovie("lol");

		System.out.println("Debug commentList: " + commentList);


	/*	Rate rate = new Rate();
		rate.setRating(9.0f);

		RateDAOImplementation rateDAOImplementation = new RateDAOImplementation();
	//	Float number = rateDAOImplementation.getRatingOnMovie("Lau","Aladin");

		//System.out.println("Debug getting rate: " + number);

		rateDAOImplementation.addRatingToMovie(rate, "KingKong","tomi");

	 */





		Comment comment = new Comment();
		comment.setComment("Thresh.");

		CommentDAOImplementation commentDAo = new CommentDAOImplementation();


		//Add Comment to movie

		commentDAo.AddCommentToMovie(comment,"Nemo","admin");

		//Register user to the database
		//	userDao.Registry(user);

		//Login Test with correct given info and without




	}



}
