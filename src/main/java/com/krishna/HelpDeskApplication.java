package com.krishna;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.krishna.config.SecurityConfig;


@EnableJpaRepositories("com.krishna.repo")
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class HelpDeskApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelpDeskApplication.class, args);
	}

}
