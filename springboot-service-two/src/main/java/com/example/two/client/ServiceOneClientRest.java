package com.example.two.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="service-one")
public interface ServiceOneClientRest {

	@GetMapping("/helloWorld")
	public String helloWorld();

	@GetMapping("/helloWorldError")
	public String helloWorldError();
	
	@GetMapping("/helloWorldTimeOut")
	public String helloWorldTimeOut();
}
