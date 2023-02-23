package com.sky.getyourway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;
import org.springframework.context.annotation.Bean;

import com.sky.getyourway.data.entity.User;
import com.sky.getyourway.data.repository.UserRepository;

@SpringBootApplication
public class GetYourWayApp {
	
	private static final Logger logger = LoggerFactory.getLogger(GetYourWayApp.class);
	
	@Autowired
	private UserRepository user_repository;

	public static void main(String[] args) {
//		SpringApplication.run(GetYourWayApp.class, args);
//		auto restart test comment

		SpringApplication application = new SpringApplication(GetYourWayApp.class);
		application.addListeners(new ApplicationPidFileWriter());
		application.run(args);

		logger.info("Hello Spring Boot");

		
	}
	
	@Bean
	CommandLineRunner runner(){
	return args -> {
		// Save demo data to database

		// Users
		
		user_repository.save(new User("admin",
				"$2a$10$LmptYa4uWhkO/OO.lpmahO14w0WKBzyKQOAXeSrYal04KKt.OTcRu",
				"ADMIN"));
		
		user_repository.save(new User("user",
				"$2a$10$6CJhx.freP/GXr56EItYJeVc2r9P3o/ns/adeKBAuf8d65Y8qz2qi",
				"USER"));

		user_repository.save(new User("steve",
				"$2a$10$4PvjxalON1iur1hRDqUJXOo9zeWdCTSMOJNWiMHBapNcHGxIdUI4y",
				"USER"));

		user_repository.save(new User("baz",
				"$2a$10$ItVVjC8b3zBkC.Kqa5XDyuQ.tF455hxqPCALOHbr5Iahaoa5n17V2",
				"USER"));

		user_repository.save(new User("chit",
				"$2a$10$.KZK6UwR7QIValPjJCwJUOZPGafeR0VgHiickTwTSx5MOlNemgrfa",
				"USER"));

		user_repository.save(new User("ant",
				"$2a$10$lnZg5GI3O/RnOvXumxZRJONshT0UziwM5j1PXpun4aNDcbbUQ0JKa",
				"USER"));

		user_repository.save(new User("corey",
				"$2a$10$N8iJhUYz76ND1SbLk3Wa9OetmKL5qqHxIZ7npEpG9Yhe9N4rVuL.C",
				"USER"));
		};
	}
	
	

}
