package com.example.accessingdatajpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
public class AccessingDataJpaApplication {

    public static final Logger log = LoggerFactory.getLogger(AccessingDataJpaApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(AccessingDataJpaApplication.class, args);
    }

    @Bean
    // Returns a CommandLineRunner bean that automatically runs the code when the application launches
    public CommandLineRunner runDemo(CustomerRepository repository) {
        // First, it fetches the CustomerRepository from the Spring application context.
        return args -> {
            // save a few customers
            List.of(new Customer("Jack", "Bauer"),
                            new Customer("Chloe", "O'Brian"),
                            new Customer("Kim", "Bauer"),
                            new Customer("David", "Palmer"),
                            new Customer("Michelle", "Dessler")
                    )
                    .stream()
                    .forEach(customer -> repository.save(customer));

            // fetch all customers
            log.info("Customers found with findAll():");
            log.info("-------------------------------");
            Stream.of(repository.findAll()).forEach(customer -> log.info(customer.toString()));
            log.info("");

            // fetch an individual customer by ID
            Customer customer = repository.findById(1L);
            log.info("Customer found with findById(1L):");
            log.info("--------------------------------");
            log.info(customer.toString());
            log.info("");

            // fetch customers by last name
            log.info("Customer found with findByLastName('Bauer'):");
            log.info("--------------------------------------------");
            repository.findByLastName("Bauer").forEach(bauer -> log.info(bauer.toString()));
            log.info("");
        };
    }
}
