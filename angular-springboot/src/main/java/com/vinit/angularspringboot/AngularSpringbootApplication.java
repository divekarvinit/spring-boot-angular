package com.vinit.angularspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class AngularSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(AngularSpringbootApplication.class, args);
	}
}
