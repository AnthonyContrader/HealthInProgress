package it.contrader;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.SpringApplication;

/**
 * 
 * Da qui parte l'applicazione SpringBoot.
 * 
 * @author SpringBoot
 *
 */
@SpringBootApplication
@ComponentScan({"it.contrader.dao"})
@EnableJpaRepositories("it.contrader.dao")
public class SpringWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringWebApplication.class, args);
	}
}
