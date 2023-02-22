package com.qa.cardatabase;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.qa.cardatabase.data.entity.Car;
import com.qa.cardatabase.data.repository.CarRepository;
import com.qa.cardatabase.data.entity.Owner;
import com.qa.cardatabase.data.repository.OwnerRepository;
import com.qa.cardatabase.data.entity.User;
import com.qa.cardatabase.data.repository.UserRepository;

import com.qa.cardatabase.service.FlightApiService;

@SpringBootApplication
public class CardatabaseApplication {
	
	private static final Logger logger = LoggerFactory.getLogger(CardatabaseApplication.class);
	
	@Autowired
	private CarRepository repository;
	
	@Autowired
	private OwnerRepository owner_repository;
	
	@Autowired
	private UserRepository user_repository;

	public static void main(String[] args) {
		SpringApplication.run(CardatabaseApplication.class, args);
//		auto restart test comment
		logger.info("Hello Spring Boot");
		
	}
	
	@Bean
	CommandLineRunner runner(){
	return args -> {
		// Save demo data to database
		// Add owner objects and save these to the database
		Owner owner1 = new Owner("Julie" , "Dooley");
		Owner owner2 = new Owner("Bob" , "Robinson");
		owner_repository.save(owner1);
		owner_repository.save(owner2);
		
		// Add cars with OWNERs
		repository.save(new Car("Ford", "Focus", "Red",
		"AB17 SWD", 2017, 59000,owner1 ));
		repository.save(new Car("Audi", "TT", "White",
		"DE14 VCL", 2014, 29000, owner1));
		repository.save(new Car("BMW", "5 Series", "Silver",
		"KK18 UYR", 2018, 39000, owner2));
		
		user_repository.save(new User("admin",
				"$2a$10$LmptYa4uWhkO/OO.lpmahO14w0WKBzyKQOAXeSrYal04KKt.OTcRu",
				"ADMIN"));
		
		user_repository.save(new User("user",
				"$2a$10$6CJhx.freP/GXr56EItYJeVc2r9P3o/ns/adeKBAuf8d65Y8qz2qi",
				"USER"));
		};
	}
	
	

}
