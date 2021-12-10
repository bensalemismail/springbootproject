package com.bensalem.springbootlearning;

import com.bensalem.springbootlearning.model.Customer;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class SpringbootLearningApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringbootLearningApplication.class, args);
	}

}
