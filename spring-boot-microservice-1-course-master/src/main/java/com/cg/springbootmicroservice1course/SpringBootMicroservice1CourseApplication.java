package com.cg.springbootmicroservice1course;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class SpringBootMicroservice1CourseApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMicroservice1CourseApplication.class, args);
	}

}
