package io.rovo.userservice;

import io.rovo.userservice.domain.Role;
import io.rovo.userservice.domain.User;
import io.rovo.userservice.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class UserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run(UserService userService) {
		return args -> {
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_MANAGER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

			userService.saveUser(new User(null, "Updesh", "uppu", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "Bhavuk", "bhau123", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "Kunal", "kutta123", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "Payal", "payal123", "1234", new ArrayList<>()));

			userService.addRoleToUser("uppu", "ROLE_USER");
			userService.addRoleToUser("bhau123", "ROLE_MANAGER");
			userService.addRoleToUser("kutta123", "ROLE_ADMIN");
			userService.addRoleToUser("kutta123", "ROLE_SUPER_ADMIN");
			userService.addRoleToUser("uppu", "ROLE_ADMIN");
			userService.addRoleToUser("payal123", "ROLE_USER");
		};
	}

}
