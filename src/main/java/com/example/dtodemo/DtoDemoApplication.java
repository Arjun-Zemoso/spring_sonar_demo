package com.example.dtodemo;

import com.example.dtodemo.model.Location;
import com.example.dtodemo.model.User;
import com.example.dtodemo.repository.LocationRepository;
import com.example.dtodemo.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DtoDemoApplication implements CommandLineRunner {
	@Bean
	public ModelMapper modelMapper(){
		return  new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(DtoDemoApplication.class, args);
	}
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private LocationRepository locationRepository;

	@Override
	public void run(String... args) throws Exception {
		Location location = new Location();
		location.setPlace("Prayagraj");
		location.setDescription("The holy city of Sangam");
		location.setLongitude(25.4358);
		location.setLatitude(81.8463);
		locationRepository.save(location);

		User user1= new User();
		user1.setFirstName("John");
		user1.setLastName("Doe");
		user1.setEmail("john.doe@example.com");
		user1.setPassword("secret123");
		user1.setLocation(location);
		userRepository.save(user1);

		User user2= new User();
		user2.setFirstName("Alyssa");
		user2.setLastName("Smith");
		user2.setEmail("alyssa.smith@example.com");
		user2.setPassword("secret123");
		user2.setLocation(location);
		userRepository.save(user2);
	}
}
