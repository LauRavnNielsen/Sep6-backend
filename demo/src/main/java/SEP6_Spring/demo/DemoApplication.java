package SEP6_Spring.demo;

import SEP6_Spring.demo.Database.DAOImplementation.UserDAOImplementation;
import SEP6_Spring.demo.Entities.User;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;


@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) throws SQLException {
		//SpringApplication.run(DemoApplication.class, args);



		User user = new User();
		user.setUserName("test");
		user.setPassword("test123");
		user.setEmail("test@gmail.com");

		UserDAOImplementation userDao = new UserDAOImplementation();

		//Register user to the database
		//	userDao.Registry(user);

		//Login Test with correct given info and without
		User e = userDao.LogIn("admin","123456");
		User f = userDao.LogIn("admin","12345");

		if(e != null) {
			System.out.println(e.getUserName() + " "
					+ e.getPassword() + " "
					+ e.getEmail() + " " + e.getUserId());
		} else
			System.out.println("Incorrect username or password");

		if(f != null) {
			System.out.println(f.getUserName() + " "
					+ f.getPassword() + " "
					+ f.getEmail());
		} else
			System.out.println("Incorrect username or password");


	}

}
