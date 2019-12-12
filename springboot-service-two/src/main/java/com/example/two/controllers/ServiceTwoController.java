package com.example.two.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.two.service.ServiceOneService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class ServiceTwoController {

	@Autowired
	private ServiceOneService serviceOneService;
	
	@GetMapping("/helloWorld")
	public String helloWorld() {
		return "Hello world, service two";
	}
	
	@GetMapping("/helloWorlds")
	public List<String> helloWorlds() {
		List<String> response = new ArrayList<String>();
		response.add(helloWorld());
		response.add(serviceOneService.helloWorld());
		return response;
	}
	
	@HystrixCommand(fallbackMethod = "alternativeMethod")
	@GetMapping("/helloWorldsError")
	public List<String> helloWorldsError() {
		List<String> response = new ArrayList<String>();
		response.add(helloWorld());
		response.add(serviceOneService.helloWorldError());
		return response;
	}
	
	@HystrixCommand(fallbackMethod = "alternativeMethodTimeOut")
	@GetMapping("/helloWorldsTimeOut")
	public List<String> helloWorldsTimeOut() {
		List<String> response = new ArrayList<String>();
		response.add(helloWorld());
		response.add(serviceOneService.helloWorldTimeOut());
		return response;
	}
	
	public List<String> alternativeMethod(){
		List<String> response = new ArrayList<String>();
		response.add(helloWorld());
		response.add("Service two error");
		return response;
	}
	
	public List<String> alternativeMethodTimeOut(){
		List<String> response = new ArrayList<String>();
		response.add(helloWorld());
		response.add("Service two error time out");
		return response;
	}
}
