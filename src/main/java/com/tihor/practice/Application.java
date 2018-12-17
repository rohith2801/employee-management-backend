package com.tihor.practice;

import com.tihor.practice.entity.EmployeeEntity;
import com.tihor.practice.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

/**
 * The type Application.
 */
@SpringBootApplication
public class Application {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    /**
     * Add default employees command line runner.
     *
     * @param repository the repository
     * @return the command line runner
     */
    @Bean
    public CommandLineRunner addDefaultEmployees(final EmployeeRepository repository) {
        return (args) -> {
            repository.save(new EmployeeEntity("Rohith Kumar", new Date()));
            repository.save(new EmployeeEntity("TIHOR", new Date()));
        };
    }
}
