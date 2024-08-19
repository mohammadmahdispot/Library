package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibApplication {

	public static void main(String[] args) {

		System.out.println("<<<<<<< Hello My Friend >>>>>>>");
		SpringApplication.run(LibApplication.class, args);
	}

}
