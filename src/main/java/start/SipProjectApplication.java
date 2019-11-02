package start;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"controllers", "database", "translation"})
@EnableJpaRepositories(basePackages = "database")
@EntityScan("database")
public class SipProjectApplication {
	public static void main(String[] args) {
		SpringApplication.run(SipProjectApplication.class, args);
	}
}
