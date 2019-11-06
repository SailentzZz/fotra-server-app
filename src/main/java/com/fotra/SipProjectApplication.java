package com.fotra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@ComponentScan(basePackages = {"controllers", "service", "database", "translation", "config"})
//@EnableJpaRepositories(basePackages = "database")
//@EntityScan("database")
public class SipProjectApplication {
	public static void main(String[] args) {
		SpringApplication.run(SipProjectApplication.class, args);
	}
}
