package com.bensalem.springbootlearning;


import com.bensalem.springbootlearning.model.ApplicationUserRole;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static com.bensalem.springbootlearning.model.ApplicationUserRole.*;


@SpringBootApplication
public class SpringbootLearningApplication {

	public static void main(String[] args) {

		System.out.println(ADMIN.getGrantedAuthorities());
		System.out.println(CUSTOMER.getGrantedAuthorities());
		SpringApplication.run(SpringbootLearningApplication.class, args);
	}

}
