package com.example.two;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableCircuitBreaker
@EnableEurekaClient
//@RibbonClient(name="service-one") No es necesario, ya que hemos configurado eureka client
@EnableFeignClients
@SpringBootApplication
public class SpringbootServiceTwoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootServiceTwoApplication.class, args);
	}

}
