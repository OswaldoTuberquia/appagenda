package co.edu.umb.academia.webservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"co.edu.umb.academia"})
@EnableAutoConfiguration
@EnableJpaRepositories(basePackages = {"co.edu.umb.academia.webservice.repo"})
public class Application {

    public static void main(String[] args) {
        System.setProperty("server.servlet.context-path", "/agendaws");
        SpringApplication.run(Application.class, args);
    }

}
