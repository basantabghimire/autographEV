package com.example.autographEV;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@Configuration
@EnableMongoAuditing
@Component
public class AutographEvApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutographEvApplication.class, args);
		System.out.println("Program now running");
	}

}
