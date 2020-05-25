package com.example.uclid;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class UclidApplication {

	public static void main(String[] args) {
		SpringApplication.run(UclidApplication.class, args);
	}
}
