package com.fotra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@ComponentScan(basePackages = {"com.fotra.controllers", "com.fotra.service", "com.fotra.database"})
@EnableJpaRepositories(basePackages = "com.fotra")
@EntityScan("com.fotra")
public class SipProjectApplication {
	public static void main(String[] args) {
		SpringApplication.run(SipProjectApplication.class, args);
	}
}
