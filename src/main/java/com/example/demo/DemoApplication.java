package com.example.demo;

import com.example.demo.student.Student;
import com.github.javafaker.Faker;
import org.apache.tomcat.jni.Local;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
@RestController
public class DemoApplication {



	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping
	public List<Student> hello(){
		Faker faker = new Faker();
		return List.of(new Student(
				faker.number().randomNumber(),
				faker.name().fullName(),
				faker.number().numberBetween(10,35),
				LocalDate.now(),
				faker.internet().emailAddress()
		));
	}
}
