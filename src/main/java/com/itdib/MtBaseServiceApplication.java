package com.itdib;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MtBaseServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MtBaseServiceApplication.class, args);
	}
	
	@Bean
	public FlywayMigrationStrategy flywayMigrationStrategy() {
		return flyway -> {
			// do nothing
		};
	}

}
