package com.alex.atos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class TutorialesBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(TutorialesBackApplication.class, args);
	}

}
