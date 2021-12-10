package com.bensalem.springbootlearning.config;

import com.bensalem.springbootlearning.model.Customer;
import com.bensalem.springbootlearning.repository.CustomerRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerTableInitializr {

    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository){
        return args -> {
            Customer customer = new Customer(
                    RandomStringUtils.randomAlphanumeric(20),
                    RandomStringUtils.randomAlphanumeric(20));
            customerRepository.save(customer);
        };
    }
}
