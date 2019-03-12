package com.henry.api;

import com.henry.api.model.YourStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class ApiApplication {

	@Autowired
	YourStoreRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

}
