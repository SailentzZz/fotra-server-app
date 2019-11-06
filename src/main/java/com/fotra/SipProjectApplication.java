package com.fotra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@ComponentScan(basePackages = {"com.fotra.controllers", "com.fotra.service", "com.fotra.database", "com.fotra.translation", "com.fotra.config"})
//@EnableJpaRepositories(basePackages = "com.fotra.database")
//@EntityScan("com.fotra.database")
public class SipProjectApplication {
	public static void main(String[] args) {
		SpringApplication.run(SipProjectApplication.class, args);
	}
}
