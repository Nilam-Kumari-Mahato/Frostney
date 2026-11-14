package com.example.Frostney;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class FrostneyApplication {

	public static void main(String[] args) {
		SpringApplication.run(FrostneyApplication.class, args);
	}
	@GetMapping
	public String helloWorld() {
		return "<h1>hello World welcome to my spring demo project learning</h1>";

	}
}
