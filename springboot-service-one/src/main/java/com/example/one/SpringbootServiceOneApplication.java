package com.example.one;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class SpringbootServiceOneApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootServiceOneApplication.class, args);
	}

}
