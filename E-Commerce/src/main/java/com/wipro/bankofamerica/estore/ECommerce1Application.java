package com.wipro.bankofamerica.estore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

//Jagdish-46
@SpringBootApplication
public class ECommerce1Application extends ServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(ECommerce1Application.class, args);
	}


	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(ECommerce1Application.class);
	}
}


