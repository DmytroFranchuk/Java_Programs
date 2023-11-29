package com.example.demo;

import com.example.demo.model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// http://localhost:8080
//Whitelabel Error Page
//This application has no explicit mapping for /error, so you are seeing this as a fallback.
//
//Wed Nov 29 20:54:45 CET 2023
//There was an unexpected error (type=Not Found, status=404).


// http://localhost:8080/users
// [{"name":"john_doe","email":"john@example.com"},{"name":"janet_smith","email":"janet@example.com"}]

@SpringBootApplication
public class FirstProgectSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstProgectSpringBootApplication.class, args);
//		User user = new User("Dima", "test@test.com");
//		System.out.println(user);
	}

}
